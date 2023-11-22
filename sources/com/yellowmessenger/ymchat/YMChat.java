package com.yellowmessenger.ymchat;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.os.Looper;
import android.widget.ExpandableListView;
import com.fullstory.instrumentation.InstrumentInjector;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yellowmessenger.ymchat.models.ConfigService;
import com.yellowmessenger.ymchat.models.YMBotEventResponse;
import com.yellowmessenger.ymchat.models.YellowCallback;
import com.yellowmessenger.ymchat.models.YellowDataCallback;
import com.yellowmessenger.ymchat.models.YellowGenericResponseModel;
import com.yellowmessenger.ymchat.models.YellowUnreadMessageResponse;
import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Objects;
import kotlin.text.Typography;
import net.sqlcipher.database.SQLiteDatabase;
import o.getCallingPid;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class YMChat {
    private static int $10 = 0;
    private static int $11 = 1;
    private static int GetContactSyncConfig = 1;
    private static int NetworkUserEntityData$$ExternalSyntheticLambda2 = 0;
    private static YMChat PlaceComponentResult = null;
    private static char[] getErrorConfigVersion = {42070, 42068, 37346, 37275, 37274, 42065, 37257, 42071, 37367};
    private static char initRecordTimeStamp = 42070;
    private BotCloseEventListener BuiltInFictitiousFunctionClassFactory;
    public YMConfig KClassImpl$Data$declaredNonStaticMembers$2;
    private BotEventListener scheduleImpl;
    private final String MyBillsEntityDataFactory = "YMChat";
    private final String NetworkUserEntityData$$ExternalSyntheticLambda0 = "/api/mobile-backend/device-token?bot=";
    private final String moveToNextValue = "/api/mobile-backend/device-token?bot=";
    private final String lookAheadTest = "/api/mobile-backend/message/unreadMsgs?bot=";
    private BotEventListener getAuthRequestContext = new BotEventListener() { // from class: com.yellowmessenger.ymchat.YMChat$$ExternalSyntheticLambda4
        @Override // com.yellowmessenger.ymchat.BotEventListener
        public final void BuiltInFictitiousFunctionClassFactory(YMBotEventResponse yMBotEventResponse) {
            YMChat.PlaceComponentResult();
        }
    };

    public static /* synthetic */ void BuiltInFictitiousFunctionClassFactory() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 9;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    public static /* synthetic */ void MyBillsEntityDataFactory() {
        int i = GetContactSyncConfig + 35;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 != 0 ? (char) 16 : '`') != '`') {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static /* synthetic */ void PlaceComponentResult() {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 17;
        GetContactSyncConfig = i % 128;
        if (i % 2 == 0) {
            Object obj = null;
            obj.hashCode();
        }
    }

    public static /* synthetic */ void getAuthRequestContext() {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 5;
            GetContactSyncConfig = i % 128;
            if (i % 2 == 0) {
                int i2 = 53 / 0;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(YellowCallback yellowCallback) {
        int i = GetContactSyncConfig + 121;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        if ((i % 2 != 0 ? Typography.quote : '=') == '=') {
            BuiltInFictitiousFunctionClassFactory(yellowCallback);
            return;
        }
        try {
            BuiltInFictitiousFunctionClassFactory(yellowCallback);
            Object obj = null;
            obj.hashCode();
        } catch (Exception e) {
            throw e;
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(YellowDataCallback yellowDataCallback, YellowUnreadMessageResponse yellowUnreadMessageResponse) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 117;
            try {
                GetContactSyncConfig = i % 128;
                if (i % 2 != 0) {
                    KClassImpl$Data$declaredNonStaticMembers$2(yellowDataCallback, yellowUnreadMessageResponse);
                } else {
                    KClassImpl$Data$declaredNonStaticMembers$2(yellowDataCallback, yellowUnreadMessageResponse);
                    int i2 = 44 / 0;
                }
                int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 57;
                GetContactSyncConfig = i3 % 128;
                int i4 = i3 % 2;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void MyBillsEntityDataFactory(YellowDataCallback yellowDataCallback, String str) {
        try {
            int i = GetContactSyncConfig + 117;
            try {
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                if ((i % 2 != 0 ? 'B' : '%') == '%') {
                    KClassImpl$Data$declaredNonStaticMembers$2(yellowDataCallback, str);
                    return;
                }
                KClassImpl$Data$declaredNonStaticMembers$2(yellowDataCallback, str);
                Object obj = null;
                obj.hashCode();
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception e2) {
            throw e2;
        }
    }

    static /* synthetic */ void PlaceComponentResult(YellowCallback yellowCallback, String str) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 93;
        GetContactSyncConfig = i % 128;
        boolean z = i % 2 != 0;
        Object obj = null;
        getAuthRequestContext(yellowCallback, str);
        if (!z) {
            obj.hashCode();
        }
        int i2 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 125;
        GetContactSyncConfig = i2 % 128;
        if ((i2 % 2 == 0 ? '7' : '^') != '7') {
            return;
        }
        obj.hashCode();
    }

    private YMChat() {
    }

    public static YMChat KClassImpl$Data$declaredNonStaticMembers$2() {
        if (PlaceComponentResult == null) {
            synchronized (YMChat.class) {
                if (PlaceComponentResult == null) {
                    PlaceComponentResult = new YMChat();
                }
            }
        }
        return PlaceComponentResult;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(BotEventListener botEventListener) {
        int i = GetContactSyncConfig + 43;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        try {
            if ((i % 2 != 0 ? 'G' : '.') != 'G') {
                this.scheduleImpl = botEventListener;
                return;
            }
            this.scheduleImpl = botEventListener;
            int i2 = 74 / 0;
        } catch (Exception e) {
            throw e;
        }
    }

    public void onEventFromBot(BotEventListener botEventListener) {
        int i = GetContactSyncConfig + 87;
        NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
        int i2 = i % 2;
        this.getAuthRequestContext = botEventListener;
        int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 5;
        GetContactSyncConfig = i3 % 128;
        if (!(i3 % 2 == 0)) {
            return;
        }
        int i4 = 7 / 0;
    }

    public final void MyBillsEntityDataFactory(Context context) throws Exception {
        try {
            PlaceComponentResult(context);
            ConfigService.MyBillsEntityDataFactory().PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2);
            Intent intent = new Intent(context, YellowBotWebViewActivity.class);
            intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            context.startActivity(intent);
            int i = GetContactSyncConfig + 5;
            NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
            if (i % 2 != 0) {
                Object[] objArr = null;
                int length = objArr.length;
            }
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("Exception in staring chat bot ::\nException message :: ");
            sb.append(e.getMessage());
            throw new Exception(sb.toString());
        }
    }

    private boolean PlaceComponentResult(Context context) throws Exception {
        if (context != null) {
            YMConfig yMConfig = this.KClassImpl$Data$declaredNonStaticMembers$2;
            if (yMConfig != null) {
                int i = GetContactSyncConfig + 41;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i % 128;
                int i2 = i % 2;
                if (yMConfig.BuiltInFictitiousFunctionClassFactory == null || this.KClassImpl$Data$declaredNonStaticMembers$2.BuiltInFictitiousFunctionClassFactory.trim().isEmpty()) {
                    throw new Exception("botId is not configured. Please set botId before calling startChatbot()");
                }
                if ((this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2 != null ? 'G' : (char) 27) != 'G' || this.KClassImpl$Data$declaredNonStaticMembers$2.KClassImpl$Data$declaredNonStaticMembers$2.isEmpty()) {
                    throw new Exception("customBaseUrl cannot be null or empty.");
                }
                if (this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue != null) {
                    int i3 = GetContactSyncConfig + 21;
                    NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                    int i4 = i3 % 2;
                    if ((!this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue.isEmpty()) && PlaceComponentResult(this.KClassImpl$Data$declaredNonStaticMembers$2.moveToNextValue)) {
                        int i5 = GetContactSyncConfig + 87;
                        NetworkUserEntityData$$ExternalSyntheticLambda2 = i5 % 128;
                        int i6 = i5 % 2;
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp != null) {
                            try {
                                String json = new Gson().toJson(this.KClassImpl$Data$declaredNonStaticMembers$2.initRecordTimeStamp);
                                Object[] objArr = new Object[1];
                                a(new char[]{5, 4, '\b', 0, 13839}, (byte) ((ExpandableListView.getPackedPositionForGroup(0) > 0L ? 1 : (ExpandableListView.getPackedPositionForGroup(0) == 0L ? 0 : -1)) + 109), Color.red(0) + 5, objArr);
                                URLEncoder.encode(json, ((String) objArr[0]).intern());
                            } catch (Exception e) {
                                StringBuilder sb = new StringBuilder();
                                sb.append("In payload map, value can be of primitive type or json convertible value ::\nException message :: ");
                                sb.append(e.getMessage());
                                throw new Exception(sb.toString());
                            }
                        }
                        if (this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 == 1 || this.KClassImpl$Data$declaredNonStaticMembers$2.NetworkUserEntityData$$ExternalSyntheticLambda8 == 2) {
                            return true;
                        }
                        throw new Exception("version can be either 1 or 2");
                    }
                }
                throw new Exception("Please provide valid customLoaderUrl");
            }
            throw new Exception("Please initialise config, it cannot be null.");
        }
        throw new Exception("Context passed is null. Please pass valid context");
    }

    private static boolean PlaceComponentResult(String str) {
        try {
            new URL(str).toURI();
            try {
                int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 87;
                GetContactSyncConfig = i % 128;
                if (i % 2 == 0) {
                    Object obj = null;
                    obj.hashCode();
                    return true;
                }
                return true;
            } catch (Exception e) {
                throw e;
            }
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x0022, code lost:
    
        if ((r2 == null) != true) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x002b, code lost:
    
        if (r2 != null) goto L94;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x002d, code lost:
    
        r2.BuiltInFictitiousFunctionClassFactory(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0031, code lost:
    
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x0032, code lost:
    
        throw r5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void getAuthRequestContext(com.yellowmessenger.ymchat.models.YMBotEventResponse r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L6
            r2 = 0
            goto L7
        L6:
            r2 = 1
        L7:
            if (r2 == 0) goto La
            goto L33
        La:
            int r2 = com.yellowmessenger.ymchat.YMChat.GetContactSyncConfig
            int r2 = r2 + 43
            int r3 = r2 % 128
            com.yellowmessenger.ymchat.YMChat.NetworkUserEntityData$$ExternalSyntheticLambda2 = r3
            int r2 = r2 % 2
            if (r2 == 0) goto L18
            r2 = 1
            goto L19
        L18:
            r2 = 0
        L19:
            if (r2 == r1) goto L25
            com.yellowmessenger.ymchat.BotEventListener r2 = r4.scheduleImpl
            if (r2 == 0) goto L21
            r3 = 0
            goto L22
        L21:
            r3 = 1
        L22:
            if (r3 == r1) goto L33
            goto L2d
        L25:
            com.yellowmessenger.ymchat.BotEventListener r2 = r4.scheduleImpl     // Catch: java.lang.Exception -> L46
            r1 = 0
            r1.hashCode()     // Catch: java.lang.Throwable -> L48
            if (r2 == 0) goto L33
        L2d:
            r2.BuiltInFictitiousFunctionClassFactory(r5)     // Catch: java.lang.Exception -> L31
            goto L33
        L31:
            r5 = move-exception
            throw r5
        L33:
            int r5 = com.yellowmessenger.ymchat.YMChat.NetworkUserEntityData$$ExternalSyntheticLambda2     // Catch: java.lang.Exception -> L46
            int r5 = r5 + 41
            int r1 = r5 % 128
            com.yellowmessenger.ymchat.YMChat.GetContactSyncConfig = r1     // Catch: java.lang.Exception -> L46
            int r5 = r5 % 2
            if (r5 != 0) goto L45
            r5 = 29
            int r5 = r5 / r0
            return
        L43:
            r5 = move-exception
            throw r5
        L45:
            return
        L46:
            r5 = move-exception
            goto L4a
        L48:
            r5 = move-exception
            throw r5
        L4a:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yellowmessenger.ymchat.YMChat.getAuthRequestContext(com.yellowmessenger.ymchat.models.YMBotEventResponse):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yellowmessenger.ymchat.YMChat$1 */
    /* loaded from: classes8.dex */
    public class AnonymousClass1 extends Thread {
        final /* synthetic */ YMConfig BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ String KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ YMChat MyBillsEntityDataFactory;
        final /* synthetic */ YellowCallback getAuthRequestContext;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceToken", this.BuiltInFictitiousFunctionClassFactory.lookAheadTest);
            } catch (JSONException unused) {
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.BuiltInFictitiousFunctionClassFactory.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("/api/mobile-backend/device-token?bot=");
            sb.append(this.BuiltInFictitiousFunctionClassFactory.BuiltInFictitiousFunctionClassFactory);
            String obj = sb.toString();
            FirebasePerfOkHttpClient.enqueue(new OkHttpClient().newCall(new Request.Builder().url(obj).addHeader("x-api-key", this.KClassImpl$Data$declaredNonStaticMembers$2).addHeader("Content-Type", "application/json").delete(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build()), new Callback() { // from class: com.yellowmessenger.ymchat.YMChat.1.1
                {
                    AnonymousClass1.this = this;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    call.cancel();
                    YMChat yMChat = AnonymousClass1.this.MyBillsEntityDataFactory;
                    YellowCallback yellowCallback = AnonymousClass1.this.getAuthRequestContext;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to unlink the device :: Error message :: ");
                    sb2.append(iOException.getMessage());
                    YMChat.PlaceComponentResult(yellowCallback, sb2.toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    InstrumentInjector.log_d("YMChat", response.body().toString());
                    if (response.isSuccessful()) {
                        ResponseBody body = response.body();
                        if (body != null) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(body.string());
                                boolean z = jSONObject2.getBoolean("success");
                                String string = jSONObject2.getString("message");
                                if (z) {
                                    YMChat yMChat = AnonymousClass1.this.MyBillsEntityDataFactory;
                                    YMChat.KClassImpl$Data$declaredNonStaticMembers$2(AnonymousClass1.this.getAuthRequestContext);
                                    return;
                                }
                                YMChat yMChat2 = AnonymousClass1.this.MyBillsEntityDataFactory;
                                YellowCallback yellowCallback = AnonymousClass1.this.getAuthRequestContext;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Failed to unlink the device :: Error message :: ");
                                sb2.append(string);
                                YMChat.PlaceComponentResult(yellowCallback, sb2.toString());
                            } catch (JSONException e) {
                                YMChat yMChat3 = AnonymousClass1.this.MyBillsEntityDataFactory;
                                YellowCallback yellowCallback2 = AnonymousClass1.this.getAuthRequestContext;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Failed to unlink the device :: Error message :: ");
                                sb3.append(e.getMessage());
                                YMChat.PlaceComponentResult(yellowCallback2, sb3.toString());
                            }
                        }
                    } else if (response.code() >= 400 && response.code() <= 499) {
                        YMChat yMChat4 = AnonymousClass1.this.MyBillsEntityDataFactory;
                        YMChat.PlaceComponentResult(AnonymousClass1.this.getAuthRequestContext, "Failed to unlink the device. Please make sure you are passing correct `apiKey`");
                    } else {
                        YMChat yMChat5 = AnonymousClass1.this.MyBillsEntityDataFactory;
                        YMChat.PlaceComponentResult(AnonymousClass1.this.getAuthRequestContext, "Failed to unlink the device. Please try after sometime.");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yellowmessenger.ymchat.YMChat$2 */
    /* loaded from: classes8.dex */
    public class AnonymousClass2 extends Thread {
        final /* synthetic */ YellowCallback KClassImpl$Data$declaredNonStaticMembers$2;
        final /* synthetic */ YMChat MyBillsEntityDataFactory;
        final /* synthetic */ String PlaceComponentResult;
        final /* synthetic */ YMConfig getAuthRequestContext;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("deviceToken", this.getAuthRequestContext.lookAheadTest);
                jSONObject.put("ymAuthenticationToken", this.getAuthRequestContext.newProxyInstance);
            } catch (JSONException unused) {
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.getAuthRequestContext.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("/api/mobile-backend/device-token?bot=");
            sb.append(this.getAuthRequestContext.BuiltInFictitiousFunctionClassFactory);
            String obj = sb.toString();
            FirebasePerfOkHttpClient.enqueue(new OkHttpClient().newCall(new Request.Builder().url(obj).addHeader("x-api-key", this.PlaceComponentResult).addHeader("Content-Type", "application/json").put(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build()), new Callback() { // from class: com.yellowmessenger.ymchat.YMChat.2.1
                {
                    AnonymousClass2.this = this;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    call.cancel();
                    YMChat yMChat = AnonymousClass2.this.MyBillsEntityDataFactory;
                    YellowCallback yellowCallback = AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to register device :: Error message :: ");
                    sb2.append(iOException.getMessage());
                    YMChat.PlaceComponentResult(yellowCallback, sb2.toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    InstrumentInjector.log_d("YMChat", response.body().toString());
                    if (response.isSuccessful()) {
                        ResponseBody body = response.body();
                        if (body != null) {
                            try {
                                JSONObject jSONObject2 = new JSONObject(body.string());
                                boolean z = jSONObject2.getBoolean("success");
                                String string = jSONObject2.getString("message");
                                if (z) {
                                    YMChat yMChat = AnonymousClass2.this.MyBillsEntityDataFactory;
                                    YMChat.KClassImpl$Data$declaredNonStaticMembers$2(AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2);
                                    return;
                                }
                                YMChat yMChat2 = AnonymousClass2.this.MyBillsEntityDataFactory;
                                YellowCallback yellowCallback = AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Failed to register device :: Error message :: ");
                                sb2.append(string);
                                YMChat.PlaceComponentResult(yellowCallback, sb2.toString());
                            } catch (JSONException e) {
                                YMChat yMChat3 = AnonymousClass2.this.MyBillsEntityDataFactory;
                                YellowCallback yellowCallback2 = AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Failed to register device :: Error message :: ");
                                sb3.append(e.getMessage());
                                YMChat.PlaceComponentResult(yellowCallback2, sb3.toString());
                            }
                        }
                    } else if (response.code() >= 400 && response.code() <= 499) {
                        YMChat yMChat4 = AnonymousClass2.this.MyBillsEntityDataFactory;
                        YMChat.PlaceComponentResult(AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2, "Failed to register device. Please make sure you are passing correct `apiKey`");
                    } else {
                        YMChat yMChat5 = AnonymousClass2.this.MyBillsEntityDataFactory;
                        YMChat.PlaceComponentResult(AnonymousClass2.this.KClassImpl$Data$declaredNonStaticMembers$2, "Failed to register device. Please try after sometime.");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.yellowmessenger.ymchat.YMChat$3 */
    /* loaded from: classes8.dex */
    public class AnonymousClass3 extends Thread {
        final /* synthetic */ YMChat BuiltInFictitiousFunctionClassFactory;
        final /* synthetic */ YellowDataCallback MyBillsEntityDataFactory;
        final /* synthetic */ YMConfig PlaceComponentResult;

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("ymAuthenticationToken", this.PlaceComponentResult.newProxyInstance);
            } catch (JSONException unused) {
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.PlaceComponentResult.KClassImpl$Data$declaredNonStaticMembers$2);
            sb.append("/api/mobile-backend/message/unreadMsgs?bot=");
            sb.append(this.PlaceComponentResult.BuiltInFictitiousFunctionClassFactory);
            String obj = sb.toString();
            FirebasePerfOkHttpClient.enqueue(new OkHttpClient().newCall(new Request.Builder().url(obj).addHeader("Content-Type", "application/json").post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString())).build()), new Callback() { // from class: com.yellowmessenger.ymchat.YMChat.3.1
                {
                    AnonymousClass3.this = this;
                }

                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    call.cancel();
                    YMChat yMChat = AnonymousClass3.this.BuiltInFictitiousFunctionClassFactory;
                    YellowDataCallback yellowDataCallback = AnonymousClass3.this.MyBillsEntityDataFactory;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Failed to get unread messages :: Error message :: ");
                    sb2.append(iOException.getMessage());
                    YMChat.MyBillsEntityDataFactory(yellowDataCallback, sb2.toString());
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) throws IOException {
                    InstrumentInjector.log_d("YMChat", response.body().toString());
                    if (response.isSuccessful()) {
                        ResponseBody body = response.body();
                        if (body != null) {
                            try {
                                YellowGenericResponseModel yellowGenericResponseModel = (YellowGenericResponseModel) new Gson().fromJson(body.string(), new TypeToken<YellowGenericResponseModel<YellowUnreadMessageResponse>>() { // from class: com.yellowmessenger.ymchat.YMChat.3.1.1
                                    {
                                        AnonymousClass1.this = this;
                                    }
                                }.getType());
                                boolean PlaceComponentResult = yellowGenericResponseModel.PlaceComponentResult();
                                String str = yellowGenericResponseModel.KClassImpl$Data$declaredNonStaticMembers$2;
                                YellowUnreadMessageResponse yellowUnreadMessageResponse = (YellowUnreadMessageResponse) yellowGenericResponseModel.PlaceComponentResult;
                                if (PlaceComponentResult) {
                                    YMChat yMChat = AnonymousClass3.this.BuiltInFictitiousFunctionClassFactory;
                                    YMChat.MyBillsEntityDataFactory(AnonymousClass3.this.MyBillsEntityDataFactory, yellowUnreadMessageResponse);
                                    return;
                                }
                                YMChat yMChat2 = AnonymousClass3.this.BuiltInFictitiousFunctionClassFactory;
                                YellowDataCallback yellowDataCallback = AnonymousClass3.this.MyBillsEntityDataFactory;
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append("Failed to get unread messages :: Error message :: ");
                                sb2.append(str);
                                YMChat.MyBillsEntityDataFactory(yellowDataCallback, sb2.toString());
                            } catch (Exception e) {
                                YMChat yMChat3 = AnonymousClass3.this.BuiltInFictitiousFunctionClassFactory;
                                YellowDataCallback yellowDataCallback2 = AnonymousClass3.this.MyBillsEntityDataFactory;
                                StringBuilder sb3 = new StringBuilder();
                                sb3.append("Failed to get unread messages :: Error message :: ");
                                sb3.append(e.getMessage());
                                YMChat.MyBillsEntityDataFactory(yellowDataCallback2, sb3.toString());
                            }
                        }
                    } else if (response.code() >= 400 && response.code() <= 499) {
                        YMChat yMChat4 = AnonymousClass3.this.BuiltInFictitiousFunctionClassFactory;
                        YMChat.MyBillsEntityDataFactory(AnonymousClass3.this.MyBillsEntityDataFactory, "Failed to get unread messages . Please make sure you are passing correct `apiKey`");
                    } else {
                        YMChat yMChat5 = AnonymousClass3.this.BuiltInFictitiousFunctionClassFactory;
                        YMChat.MyBillsEntityDataFactory(AnonymousClass3.this.MyBillsEntityDataFactory, "Failed to get unread messages . Please try after sometime.");
                    }
                }
            });
        }
    }

    private static void getAuthRequestContext(final YellowCallback yellowCallback, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yellowmessenger.ymchat.YMChat$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                YMChat.BuiltInFictitiousFunctionClassFactory();
            }
        });
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 107;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void BuiltInFictitiousFunctionClassFactory(final YellowCallback yellowCallback) {
        try {
            Handler handler = new Handler(Looper.getMainLooper());
            Objects.requireNonNull(yellowCallback);
            handler.post(new Runnable() { // from class: com.yellowmessenger.ymchat.YMChat$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                }
            });
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 49;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
        } catch (Exception e) {
            throw e;
        }
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(final YellowDataCallback yellowDataCallback, final String str) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yellowmessenger.ymchat.YMChat$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                YMChat.getAuthRequestContext();
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 113;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
    }

    private static void KClassImpl$Data$declaredNonStaticMembers$2(final YellowDataCallback yellowDataCallback, final YellowUnreadMessageResponse yellowUnreadMessageResponse) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.yellowmessenger.ymchat.YMChat$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                YMChat.MyBillsEntityDataFactory();
            }
        });
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 81;
        GetContactSyncConfig = i % 128;
        if (!(i % 2 == 0)) {
            return;
        }
        Object[] objArr = null;
        int length = objArr.length;
    }

    private static boolean MyBillsEntityDataFactory(YMBotEventResponse yMBotEventResponse) {
        int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 35;
        GetContactSyncConfig = i % 128;
        int i2 = i % 2;
        if (yMBotEventResponse.PlaceComponentResult != null) {
            try {
                int i3 = GetContactSyncConfig + 109;
                NetworkUserEntityData$$ExternalSyntheticLambda2 = i3 % 128;
                if (i3 % 2 != 0) {
                    boolean equals = yMBotEventResponse.PlaceComponentResult.equals("bot-closed");
                    Object obj = null;
                    obj.hashCode();
                    if (!(equals)) {
                        return false;
                    }
                } else {
                    if (!yMBotEventResponse.PlaceComponentResult.equals("bot-closed")) {
                        return false;
                    }
                }
                return true;
            } catch (Exception e) {
                throw e;
            }
        }
        return false;
    }

    public final void KClassImpl$Data$declaredNonStaticMembers$2(YMBotEventResponse yMBotEventResponse) {
        try {
            int i = NetworkUserEntityData$$ExternalSyntheticLambda2 + 119;
            GetContactSyncConfig = i % 128;
            int i2 = i % 2;
            if (yMBotEventResponse != null) {
                boolean z = false;
                if (!(this.BuiltInFictitiousFunctionClassFactory == null)) {
                    int i3 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 115;
                    GetContactSyncConfig = i3 % 128;
                    int i4 = i3 % 2;
                    if (yMBotEventResponse.PlaceComponentResult != null && MyBillsEntityDataFactory(yMBotEventResponse)) {
                        int i5 = GetContactSyncConfig + 85;
                        NetworkUserEntityData$$ExternalSyntheticLambda2 = i5 % 128;
                        int i6 = i5 % 2;
                        int i7 = NetworkUserEntityData$$ExternalSyntheticLambda2 + 43;
                        GetContactSyncConfig = i7 % 128;
                        int i8 = i7 % 2;
                        return;
                    }
                }
                BotEventListener botEventListener = this.getAuthRequestContext;
                if (botEventListener == null) {
                    z = true;
                }
                if (!z) {
                    botEventListener.BuiltInFictitiousFunctionClassFactory(yMBotEventResponse);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private static void a(char[] cArr, byte b, int i, Object[] objArr) {
        int i2;
        int length;
        char[] cArr2;
        getCallingPid getcallingpid = new getCallingPid();
        try {
            char[] cArr3 = getErrorConfigVersion;
            if ((cArr3 != null ? '^' : Typography.less) != '<') {
                int i3 = $11 + 83;
                $10 = i3 % 128;
                if (i3 % 2 == 0) {
                    length = cArr3.length;
                    cArr2 = new char[length];
                } else {
                    length = cArr3.length;
                    cArr2 = new char[length];
                }
                for (int i4 = 0; i4 < length; i4++) {
                    cArr2[i4] = (char) (cArr3[i4] ^ (-1549216646985767851L));
                }
                cArr3 = cArr2;
            }
            char c = (char) (initRecordTimeStamp ^ (-1549216646985767851L));
            char[] cArr4 = new char[i];
            if ((i % 2 != 0 ? (char) 17 : '*') != 17) {
                i2 = i;
            } else {
                i2 = i - 1;
                cArr4[i2] = (char) (cArr[i2] - b);
            }
            if (i2 > 1) {
                int i5 = $11 + 89;
                $10 = i5 % 128;
                int i6 = i5 % 2;
                getcallingpid.getAuthRequestContext = 0;
                while (true) {
                    if (getcallingpid.getAuthRequestContext >= i2) {
                        break;
                    }
                    getcallingpid.MyBillsEntityDataFactory = cArr[getcallingpid.getAuthRequestContext];
                    getcallingpid.PlaceComponentResult = cArr[getcallingpid.getAuthRequestContext + 1];
                    if ((getcallingpid.MyBillsEntityDataFactory == getcallingpid.PlaceComponentResult ? Typography.dollar : (char) 21) == '$') {
                        cArr4[getcallingpid.getAuthRequestContext] = (char) (getcallingpid.MyBillsEntityDataFactory - b);
                        cArr4[getcallingpid.getAuthRequestContext + 1] = (char) (getcallingpid.PlaceComponentResult - b);
                    } else {
                        try {
                            getcallingpid.BuiltInFictitiousFunctionClassFactory = getcallingpid.MyBillsEntityDataFactory / c;
                            getcallingpid.scheduleImpl = getcallingpid.MyBillsEntityDataFactory % c;
                            getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = getcallingpid.PlaceComponentResult / c;
                            getcallingpid.lookAheadTest = getcallingpid.PlaceComponentResult % c;
                            if ((getcallingpid.scheduleImpl == getcallingpid.lookAheadTest ? (char) 5 : '4') == 5) {
                                getcallingpid.BuiltInFictitiousFunctionClassFactory = ((getcallingpid.BuiltInFictitiousFunctionClassFactory + c) - 1) % c;
                                getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 = ((getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 + c) - 1) % c;
                                int i7 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i8 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr3[i7];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i8];
                            } else if (!(getcallingpid.BuiltInFictitiousFunctionClassFactory != getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2)) {
                                int i9 = $10 + 59;
                                $11 = i9 % 128;
                                int i10 = i9 % 2;
                                getcallingpid.scheduleImpl = ((getcallingpid.scheduleImpl + c) - 1) % c;
                                getcallingpid.lookAheadTest = ((getcallingpid.lookAheadTest + c) - 1) % c;
                                int i11 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.scheduleImpl;
                                int i12 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.lookAheadTest;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr3[i11];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i12];
                            } else {
                                int i13 = (getcallingpid.BuiltInFictitiousFunctionClassFactory * c) + getcallingpid.lookAheadTest;
                                int i14 = (getcallingpid.KClassImpl$Data$declaredNonStaticMembers$2 * c) + getcallingpid.scheduleImpl;
                                cArr4[getcallingpid.getAuthRequestContext] = cArr3[i13];
                                cArr4[getcallingpid.getAuthRequestContext + 1] = cArr3[i14];
                            }
                        } catch (Exception e) {
                            throw e;
                        }
                    }
                    getcallingpid.getAuthRequestContext += 2;
                }
            }
            int i15 = 0;
            while (true) {
                if ((i15 < i ? 'G' : '%') == '%') {
                    objArr[0] = new String(cArr4);
                    return;
                } else {
                    cArr4[i15] = (char) (cArr4[i15] ^ 13722);
                    i15++;
                }
            }
        } catch (Exception e2) {
            throw e2;
        }
    }
}
