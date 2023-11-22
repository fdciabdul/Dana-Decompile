package com.mixpanel.android.viewcrawler;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Base64OutputStream;
import android.util.JsonWriter;
import android.view.View;
import com.alipay.mobile.rome.syncsdk.transport.connection.d;
import com.mixpanel.android.mpmetrics.MPConfig;
import com.mixpanel.android.mpmetrics.MixpanelAPI;
import com.mixpanel.android.mpmetrics.OnMixpanelTweaksUpdatedListener;
import com.mixpanel.android.mpmetrics.ResourceReader;
import com.mixpanel.android.mpmetrics.SuperPropertyUpdate;
import com.mixpanel.android.mpmetrics.Tweaks;
import com.mixpanel.android.util.ImageStore;
import com.mixpanel.android.util.JSONUtils;
import com.mixpanel.android.util.MPLog;
import com.mixpanel.android.util.MPPair;
import com.mixpanel.android.viewcrawler.EditProtocol;
import com.mixpanel.android.viewcrawler.EditState;
import com.mixpanel.android.viewcrawler.EditorConnection;
import com.mixpanel.android.viewcrawler.FlipGesture;
import com.mixpanel.android.viewcrawler.ViewSnapshot;
import com.mixpanel.android.viewcrawler.ViewVisitor;
import id.dana.analytics.tracker.TrackerKey;
import id.dana.data.Source;
import id.dana.data.toggle.tracker.ToggleEvent;
import id.dana.oauth.OauthConstant;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ViewCrawler implements UpdatesFromMixpanel, TrackingDebug, ViewVisitor.OnLayoutErrorListener {
    private final Map<String, String> BuiltInFictitiousFunctionClassFactory;
    private final DynamicEventTracker MyBillsEntityDataFactory;
    private final MixpanelAPI NetworkUserEntityData$$ExternalSyntheticLambda0;
    private final Context PlaceComponentResult;
    private final MPConfig getAuthRequestContext;
    private final ViewCrawlerHandler getErrorConfigVersion;
    private final Tweaks moveToNextValue;
    private final EditState KClassImpl$Data$declaredNonStaticMembers$2 = new EditState();
    private final float lookAheadTest = Resources.getSystem().getDisplayMetrics().scaledDensity;
    private final Set<OnMixpanelTweaksUpdatedListener> scheduleImpl = Collections.newSetFromMap(new ConcurrentHashMap());

    public ViewCrawler(Context context, String str, MixpanelAPI mixpanelAPI, Tweaks tweaks) {
        this.getAuthRequestContext = MPConfig.getAuthRequestContext(context);
        this.PlaceComponentResult = context;
        this.moveToNextValue = tweaks;
        this.BuiltInFictitiousFunctionClassFactory = mixpanelAPI.MyBillsEntityDataFactory;
        HandlerThread handlerThread = new HandlerThread(ViewCrawler.class.getCanonicalName());
        handlerThread.setPriority(10);
        handlerThread.start();
        ViewCrawlerHandler viewCrawlerHandler = new ViewCrawlerHandler(context, str, handlerThread.getLooper(), this);
        this.getErrorConfigVersion = viewCrawlerHandler;
        this.MyBillsEntityDataFactory = new DynamicEventTracker(mixpanelAPI, viewCrawlerHandler);
        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = mixpanelAPI;
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new LifecycleCallbacks());
        Tweaks.OnTweakDeclaredListener onTweakDeclaredListener = new Tweaks.OnTweakDeclaredListener() { // from class: com.mixpanel.android.viewcrawler.ViewCrawler.1
            {
                ViewCrawler.this = this;
            }
        };
        synchronized (tweaks) {
            tweaks.MyBillsEntityDataFactory.add(onTweakDeclaredListener);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public final void BuiltInFictitiousFunctionClassFactory() {
        this.getErrorConfigVersion.PlaceComponentResult.unlock();
        ViewCrawlerHandler viewCrawlerHandler = this.getErrorConfigVersion;
        viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(0));
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public final void getAuthRequestContext() {
        ViewCrawlerHandler viewCrawlerHandler = this.getErrorConfigVersion;
        viewCrawlerHandler.sendMessage(viewCrawlerHandler.obtainMessage(0));
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public final void PlaceComponentResult(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.getErrorConfigVersion.obtainMessage(13);
            obtainMessage.obj = jSONArray;
            this.getErrorConfigVersion.sendMessage(obtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public final void BuiltInFictitiousFunctionClassFactory(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.getErrorConfigVersion.obtainMessage(5);
            obtainMessage.obj = jSONArray;
            this.getErrorConfigVersion.sendMessage(obtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.UpdatesFromMixpanel
    public final void getAuthRequestContext(JSONArray jSONArray) {
        if (jSONArray != null) {
            Message obtainMessage = this.getErrorConfigVersion.obtainMessage(9);
            obtainMessage.obj = jSONArray;
            this.getErrorConfigVersion.sendMessage(obtainMessage);
        }
    }

    @Override // com.mixpanel.android.viewcrawler.TrackingDebug
    public final void BuiltInFictitiousFunctionClassFactory(String str) {
        Message obtainMessage = this.getErrorConfigVersion.obtainMessage();
        obtainMessage.what = 7;
        obtainMessage.obj = str;
        this.getErrorConfigVersion.sendMessage(obtainMessage);
    }

    @Override // com.mixpanel.android.viewcrawler.ViewVisitor.OnLayoutErrorListener
    public final void getAuthRequestContext(ViewVisitor.LayoutErrorMessage layoutErrorMessage) {
        Message obtainMessage = this.getErrorConfigVersion.obtainMessage();
        obtainMessage.what = 12;
        obtainMessage.obj = layoutErrorMessage;
        this.getErrorConfigVersion.sendMessage(obtainMessage);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class EmulatorConnector implements Runnable {
        volatile boolean PlaceComponentResult = true;

        public EmulatorConnector() {
            ViewCrawler.this = r1;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (!this.PlaceComponentResult) {
                ViewCrawler.this.getErrorConfigVersion.sendMessage(ViewCrawler.this.getErrorConfigVersion.obtainMessage(1));
            }
            ViewCrawler.this.getErrorConfigVersion.postDelayed(this, 30000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class LifecycleCallbacks implements Application.ActivityLifecycleCallbacks, FlipGesture.OnFlipGestureListener {
        private final FlipGesture BuiltInFictitiousFunctionClassFactory = new FlipGesture(this);
        private final EmulatorConnector getAuthRequestContext;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        public LifecycleCallbacks() {
            ViewCrawler.this = r2;
            this.getAuthRequestContext = new EmulatorConnector();
        }

        @Override // com.mixpanel.android.viewcrawler.FlipGesture.OnFlipGestureListener
        public final void BuiltInFictitiousFunctionClassFactory() {
            ViewCrawler.this.NetworkUserEntityData$$ExternalSyntheticLambda0.MyBillsEntityDataFactory("$ab_gesture3");
            ViewCrawler.this.getErrorConfigVersion.sendMessage(ViewCrawler.this.getErrorConfigVersion.obtainMessage(1));
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            ViewCrawler.this.KClassImpl$Data$declaredNonStaticMembers$2.getAuthRequestContext(activity);
            if (!PlaceComponentResult() || ViewCrawler.this.getAuthRequestContext.getAuthRequestContext()) {
                if (ViewCrawler.this.getAuthRequestContext.moveToNextValue()) {
                    return;
                }
                ((SensorManager) activity.getSystemService("sensor")).unregisterListener(this.BuiltInFictitiousFunctionClassFactory);
                return;
            }
            EmulatorConnector emulatorConnector = this.getAuthRequestContext;
            emulatorConnector.PlaceComponentResult = true;
            ViewCrawler.this.getErrorConfigVersion.removeCallbacks(emulatorConnector);
        }

        private static boolean PlaceComponentResult() {
            if (Build.HARDWARE.toLowerCase().equals("goldfish") || Build.HARDWARE.toLowerCase().equals("ranchu")) {
                return (Build.BRAND.toLowerCase().startsWith("generic") || Build.BRAND.toLowerCase().equals("android") || Build.BRAND.toLowerCase().equals(Source.GOOGLE)) && Build.DEVICE.toLowerCase().startsWith("generic") && Build.PRODUCT.toLowerCase().contains(OauthConstant.OauthType.SDK_TYPE) && Build.MODEL.toLowerCase(Locale.US).contains(OauthConstant.OauthType.SDK_TYPE);
            }
            return false;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            if (!PlaceComponentResult() || ViewCrawler.this.getAuthRequestContext.getAuthRequestContext()) {
                if (!ViewCrawler.this.getAuthRequestContext.moveToNextValue()) {
                    SensorManager sensorManager = (SensorManager) activity.getSystemService("sensor");
                    sensorManager.registerListener(this.BuiltInFictitiousFunctionClassFactory, sensorManager.getDefaultSensor(1), 3);
                }
            } else {
                EmulatorConnector emulatorConnector = this.getAuthRequestContext;
                emulatorConnector.PlaceComponentResult = false;
                ViewCrawler.this.getErrorConfigVersion.post(emulatorConnector);
            }
            ViewCrawler.this.KClassImpl$Data$declaredNonStaticMembers$2.PlaceComponentResult2(activity);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public class ViewCrawlerHandler extends Handler {
        private final Set<VariantTweak> BuiltInFictitiousFunctionClassFactory;
        private final Set<MPPair<Integer, Integer>> DatabaseTableConfigUtil;
        private final Set<MPPair<String, JSONObject>> GetContactSyncConfig;
        private final List<String> KClassImpl$Data$declaredNonStaticMembers$2;
        private EditorConnection NetworkUserEntityData$$ExternalSyntheticLambda0;
        private final ImageStore NetworkUserEntityData$$ExternalSyntheticLambda1;
        private final Set<MPPair<String, JSONObject>> NetworkUserEntityData$$ExternalSyntheticLambda2;
        final Lock PlaceComponentResult;
        private final String PrepareContext;
        private final Set<VariantChange> getAuthRequestContext;
        private final Map<String, MPPair<String, Object>> getErrorConfigVersion;
        private final EditProtocol initRecordTimeStamp;
        private final Set<MPPair<Integer, Integer>> lookAheadTest;
        private final Map<String, MPPair<String, JSONObject>> moveToNextValue;
        private ViewSnapshot newProxyInstance;
        private final Map<String, MPPair<String, JSONObject>> scheduleImpl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ViewCrawlerHandler(Context context, String str, Looper looper, ViewVisitor.OnLayoutErrorListener onLayoutErrorListener) {
            super(looper);
            ViewCrawler.this = r1;
            this.PrepareContext = str;
            this.newProxyInstance = null;
            String str2 = r1.getAuthRequestContext.NetworkUserEntityData$$ExternalSyntheticLambda7;
            ResourceReader.Ids ids = new ResourceReader.Ids(str2 == null ? context.getPackageName() : str2, context);
            ImageStore imageStore = new ImageStore(context, "ViewCrawler");
            this.NetworkUserEntityData$$ExternalSyntheticLambda1 = imageStore;
            this.initRecordTimeStamp = new EditProtocol(context, ids, imageStore, onLayoutErrorListener);
            this.GetContactSyncConfig = new HashSet();
            this.scheduleImpl = new HashMap();
            this.getErrorConfigVersion = new HashMap();
            this.KClassImpl$Data$declaredNonStaticMembers$2 = new ArrayList();
            this.moveToNextValue = new HashMap();
            this.getAuthRequestContext = new HashSet();
            this.BuiltInFictitiousFunctionClassFactory = new HashSet();
            this.lookAheadTest = new HashSet();
            this.NetworkUserEntityData$$ExternalSyntheticLambda2 = new HashSet();
            this.DatabaseTableConfigUtil = new HashSet();
            ReentrantLock reentrantLock = new ReentrantLock();
            this.PlaceComponentResult = reentrantLock;
            reentrantLock.lock();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v23, types: [com.mixpanel.android.viewcrawler.ViewSnapshot] */
        /* JADX WARN: Type inference failed for: r2v24, types: [java.io.Writer] */
        /* JADX WARN: Type inference failed for: r2v27, types: [java.io.Writer, java.io.OutputStreamWriter] */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            this.PlaceComponentResult.lock();
            try {
                int i = 1;
                byte b = 0;
                switch (message.what) {
                    case 0:
                        SharedPreferences BuiltInFictitiousFunctionClassFactory = BuiltInFictitiousFunctionClassFactory();
                        String string = BuiltInFictitiousFunctionClassFactory.getString("mixpanel.viewcrawler.changes", null);
                        String string2 = BuiltInFictitiousFunctionClassFactory.getString("mixpanel.viewcrawler.bindings", null);
                        this.getAuthRequestContext.clear();
                        this.BuiltInFictitiousFunctionClassFactory.clear();
                        this.DatabaseTableConfigUtil.clear();
                        BuiltInFictitiousFunctionClassFactory(string, false);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                        BuiltInFictitiousFunctionClassFactory(string2);
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    case 1:
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "connecting to editor");
                        EditorConnection editorConnection = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (editorConnection == null || !editorConnection.BuiltInFictitiousFunctionClassFactory()) {
                            SSLSocketFactory initRecordTimeStamp = ViewCrawler.this.getAuthRequestContext.initRecordTimeStamp();
                            if (initRecordTimeStamp == null) {
                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "SSL is not available on this device, no connection will be attempted to the events editor.");
                            } else {
                                StringBuilder sb = new StringBuilder();
                                sb.append(MPConfig.getAuthRequestContext(ViewCrawler.this.PlaceComponentResult).getErrorConfigVersion);
                                sb.append(this.PrepareContext);
                                String obj = sb.toString();
                                try {
                                    try {
                                        this.NetworkUserEntityData$$ExternalSyntheticLambda0 = new EditorConnection(new URI(obj), new Editor(ViewCrawler.this, (byte) 0), initRecordTimeStamp.createSocket());
                                    } catch (EditorConnection.EditorConnectionException e) {
                                        StringBuilder sb2 = new StringBuilder();
                                        sb2.append("Error connecting to URI ");
                                        sb2.append(obj);
                                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", sb2.toString(), e);
                                    } catch (IOException e2) {
                                        MPLog.PlaceComponentResult("MixpanelAPI.ViewCrawler", "Can't create SSL Socket to connect to editor service", e2);
                                    }
                                } catch (URISyntaxException e3) {
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("Error parsing URI ");
                                    sb3.append(obj);
                                    sb3.append(" for editor websocket");
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", sb3.toString(), e3);
                                }
                            }
                        } else {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "There is already a valid connection to an events editor.");
                        }
                        return;
                    case 2:
                        JSONObject jSONObject = (JSONObject) message.obj;
                        long currentTimeMillis = System.currentTimeMillis();
                        try {
                            try {
                                JSONObject jSONObject2 = jSONObject.getJSONObject("payload");
                                if (jSONObject2.has("config")) {
                                    this.newProxyInstance = this.initRecordTimeStamp.BuiltInFictitiousFunctionClassFactory(jSONObject2);
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Initializing snapshot with configuration");
                                }
                                ?? r2 = this.newProxyInstance;
                                if (r2 == 0) {
                                    getAuthRequestContext("No snapshot configuration (or a malformed snapshot configuration) was sent.");
                                    MPLog.BuiltInFictitiousFunctionClassFactory("MixpanelAPI.ViewCrawler", "Mixpanel editor is misconfigured, sent a snapshot request without a valid configuration.");
                                } else {
                                    try {
                                        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new EditorConnection.WebSocketOutputStream(this.NetworkUserEntityData$$ExternalSyntheticLambda0, b));
                                        r2 = new OutputStreamWriter(bufferedOutputStream);
                                        try {
                                            r2.write("{");
                                            r2.write("\"type\": \"snapshot_response\",");
                                            r2.write("\"payload\": {");
                                            r2.write("\"activities\":");
                                            r2.flush();
                                            ViewSnapshot viewSnapshot = this.newProxyInstance;
                                            viewSnapshot.MyBillsEntityDataFactory.PlaceComponentResult = ViewCrawler.this.KClassImpl$Data$declaredNonStaticMembers$2;
                                            FutureTask futureTask = new FutureTask(viewSnapshot.MyBillsEntityDataFactory);
                                            viewSnapshot.BuiltInFictitiousFunctionClassFactory.post(futureTask);
                                            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
                                            List emptyList = Collections.emptyList();
                                            outputStreamWriter.write("[");
                                            try {
                                                emptyList = (List) futureTask.get(1L, TimeUnit.SECONDS);
                                            } catch (InterruptedException e4) {
                                                MPLog.getAuthRequestContext("MixpanelAPI.Snapshot", "Screenshot interrupted, no screenshot will be sent.", e4);
                                            } catch (ExecutionException e5) {
                                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.Snapshot", "Exception thrown during screenshot attempt", e5);
                                            } catch (TimeoutException e6) {
                                                MPLog.PlaceComponentResult("MixpanelAPI.Snapshot", "Screenshot took more than 1 second to be scheduled and executed. No screenshot will be sent.", e6);
                                            }
                                            int size = emptyList.size();
                                            int i2 = 0;
                                            while (i2 < size) {
                                                if (i2 > 0) {
                                                    outputStreamWriter.write(",");
                                                }
                                                ViewSnapshot.RootViewInfo rootViewInfo = (ViewSnapshot.RootViewInfo) emptyList.get(i2);
                                                outputStreamWriter.write("{");
                                                outputStreamWriter.write("\"activity\":");
                                                outputStreamWriter.write(JSONObject.quote(rootViewInfo.MyBillsEntityDataFactory));
                                                outputStreamWriter.write(",");
                                                outputStreamWriter.write("\"scale\":");
                                                Object[] objArr = new Object[i];
                                                objArr[b] = Float.valueOf(rootViewInfo.BuiltInFictitiousFunctionClassFactory);
                                                outputStreamWriter.write(String.format("%s", objArr));
                                                outputStreamWriter.write(",");
                                                outputStreamWriter.write("\"serialized_objects\":");
                                                JsonWriter jsonWriter = new JsonWriter(outputStreamWriter);
                                                jsonWriter.beginObject();
                                                jsonWriter.name("rootObject").value(rootViewInfo.KClassImpl$Data$declaredNonStaticMembers$2.hashCode());
                                                jsonWriter.name("objects");
                                                View view = rootViewInfo.KClassImpl$Data$declaredNonStaticMembers$2;
                                                jsonWriter.beginArray();
                                                viewSnapshot = viewSnapshot;
                                                viewSnapshot.KClassImpl$Data$declaredNonStaticMembers$2(jsonWriter, view);
                                                jsonWriter.endArray();
                                                jsonWriter.endObject();
                                                jsonWriter.flush();
                                                outputStreamWriter.write(",");
                                                outputStreamWriter.write("\"screenshot\":");
                                                outputStreamWriter.flush();
                                                ViewSnapshot.CachedBitmap cachedBitmap = rootViewInfo.PlaceComponentResult;
                                                synchronized (cachedBitmap) {
                                                    Bitmap bitmap = cachedBitmap.PlaceComponentResult;
                                                    if (bitmap != null && bitmap.getWidth() != 0 && cachedBitmap.PlaceComponentResult.getHeight() != 0) {
                                                        bufferedOutputStream.write(34);
                                                        Base64OutputStream base64OutputStream = new Base64OutputStream(bufferedOutputStream, 2);
                                                        cachedBitmap.PlaceComponentResult.compress(Bitmap.CompressFormat.PNG, 100, base64OutputStream);
                                                        base64OutputStream.flush();
                                                        bufferedOutputStream.write(34);
                                                    }
                                                    bufferedOutputStream.write("null".getBytes());
                                                }
                                                outputStreamWriter.write("}");
                                                i2++;
                                                i = 1;
                                                b = 0;
                                            }
                                            outputStreamWriter.write("]");
                                            outputStreamWriter.flush();
                                            long currentTimeMillis2 = System.currentTimeMillis();
                                            r2.write(",\"snapshot_time_millis\": ");
                                            r2.write(Long.toString(currentTimeMillis2 - currentTimeMillis));
                                            r2.write("}");
                                            r2.write("}");
                                        } catch (IOException e7) {
                                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't write snapshot request to server", e7);
                                        }
                                        try {
                                            r2.close();
                                        } catch (IOException e8) {
                                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't close writer.", e8);
                                        }
                                    } finally {
                                    }
                                }
                            } catch (JSONException e9) {
                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Payload with snapshot config required with snapshot request", e9);
                                getAuthRequestContext("Payload with snapshot config required with snapshot request");
                            }
                        } catch (EditProtocol.BadInstructionsException e10) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Editor sent malformed message with snapshot request", e10);
                            getAuthRequestContext(e10.getMessage());
                        }
                        return;
                    case 3:
                        try {
                            JSONArray jSONArray = ((JSONObject) message.obj).getJSONObject("payload").getJSONArray("actions");
                            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                                JSONObject jSONObject3 = jSONArray.getJSONObject(i3);
                                this.scheduleImpl.put(jSONObject3.getString("name"), new MPPair<>(JSONUtils.PlaceComponentResult(jSONObject3, "target_activity"), jSONObject3));
                            }
                            KClassImpl$Data$declaredNonStaticMembers$2();
                        } catch (JSONException e11) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad change request received", e11);
                        }
                        return;
                    case 4:
                        EditorConnection editorConnection2 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (editorConnection2 != null && editorConnection2.BuiltInFictitiousFunctionClassFactory() && this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext()) {
                            JsonWriter jsonWriter2 = new JsonWriter(new OutputStreamWriter(new BufferedOutputStream(new EditorConnection.WebSocketOutputStream(this.NetworkUserEntityData$$ExternalSyntheticLambda0, b))));
                            try {
                                try {
                                    jsonWriter2.beginObject();
                                    jsonWriter2.name("type").value("device_info_response");
                                    jsonWriter2.name("payload").beginObject();
                                    jsonWriter2.name("device_type").value("Android");
                                    JsonWriter name = jsonWriter2.name("device_name");
                                    StringBuilder sb4 = new StringBuilder();
                                    sb4.append(Build.BRAND);
                                    sb4.append("/");
                                    sb4.append(Build.MODEL);
                                    name.value(sb4.toString());
                                    jsonWriter2.name("scaled_density").value(ViewCrawler.this.lookAheadTest);
                                    for (Map.Entry entry : ViewCrawler.this.BuiltInFictitiousFunctionClassFactory.entrySet()) {
                                        jsonWriter2.name((String) entry.getKey()).value((String) entry.getValue());
                                    }
                                    Map<String, Tweaks.TweakValue> authRequestContext = ViewCrawler.this.moveToNextValue.getAuthRequestContext();
                                    jsonWriter2.name("tweaks").beginArray();
                                    for (Map.Entry<String, Tweaks.TweakValue> entry2 : authRequestContext.entrySet()) {
                                        Tweaks.TweakValue value = entry2.getValue();
                                        String key = entry2.getKey();
                                        jsonWriter2.beginObject();
                                        jsonWriter2.name("name").value(key);
                                        jsonWriter2.name("minimum").value(value.MyBillsEntityDataFactory);
                                        jsonWriter2.name("maximum").value(value.KClassImpl$Data$declaredNonStaticMembers$2);
                                        int i4 = value.getAuthRequestContext;
                                        if (i4 == 1) {
                                            jsonWriter2.name("type").value("boolean");
                                            jsonWriter2.name("value").value(value.MyBillsEntityDataFactory().booleanValue());
                                            jsonWriter2.name("default").value(((Boolean) value.PlaceComponentResult).booleanValue());
                                        } else if (i4 == 2) {
                                            jsonWriter2.name("type").value("number");
                                            jsonWriter2.name("encoding").value(d.f7256a);
                                            jsonWriter2.name("value").value(value.KClassImpl$Data$declaredNonStaticMembers$2().doubleValue());
                                            jsonWriter2.name("default").value(((Number) value.PlaceComponentResult).doubleValue());
                                        } else if (i4 == 3) {
                                            jsonWriter2.name("type").value("number");
                                            jsonWriter2.name("encoding").value("l");
                                            jsonWriter2.name("value").value(value.KClassImpl$Data$declaredNonStaticMembers$2().longValue());
                                            jsonWriter2.name("default").value(((Number) value.PlaceComponentResult).longValue());
                                        } else if (i4 == 4) {
                                            jsonWriter2.name("type").value("string");
                                            jsonWriter2.name("value").value(value.getAuthRequestContext());
                                            jsonWriter2.name("default").value((String) value.PlaceComponentResult);
                                        } else {
                                            int i5 = value.getAuthRequestContext;
                                            MPLog.getAuthRequestContext();
                                        }
                                        jsonWriter2.endObject();
                                    }
                                    jsonWriter2.endArray();
                                    jsonWriter2.endObject();
                                    jsonWriter2.endObject();
                                } finally {
                                }
                            } catch (IOException e12) {
                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't write device_info to server", e12);
                            }
                            try {
                                jsonWriter2.close();
                            } catch (IOException e13) {
                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't close websocket writer", e13);
                            }
                        }
                        return;
                    case 5:
                        JSONArray jSONArray2 = (JSONArray) message.obj;
                        SharedPreferences.Editor edit = BuiltInFictitiousFunctionClassFactory().edit();
                        edit.putString("mixpanel.viewcrawler.bindings", jSONArray2.toString());
                        edit.apply();
                        BuiltInFictitiousFunctionClassFactory(jSONArray2.toString());
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    case 6:
                        try {
                            JSONArray jSONArray3 = ((JSONObject) message.obj).getJSONObject("payload").getJSONArray("events");
                            int length = jSONArray3.length();
                            this.moveToNextValue.clear();
                            if (!this.NetworkUserEntityData$$ExternalSyntheticLambda2.isEmpty() && this.GetContactSyncConfig.isEmpty()) {
                                this.GetContactSyncConfig.addAll(this.NetworkUserEntityData$$ExternalSyntheticLambda2);
                                for (MPPair<String, JSONObject> mPPair : this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                                    try {
                                        this.moveToNextValue.put(((JSONObject) mPPair.second).get("path").toString(), mPPair);
                                    } catch (JSONException unused) {
                                    }
                                }
                                this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                            }
                            for (int i6 = 0; i6 < length; i6++) {
                                try {
                                    JSONObject jSONObject4 = jSONArray3.getJSONObject(i6);
                                    this.moveToNextValue.put(jSONObject4.get("path").toString(), new MPPair<>(JSONUtils.PlaceComponentResult(jSONObject4, "target_activity"), jSONObject4));
                                } catch (JSONException e14) {
                                    StringBuilder sb5 = new StringBuilder();
                                    sb5.append("Bad event binding received from editor in ");
                                    sb5.append(jSONArray3.toString());
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", sb5.toString(), e14);
                                }
                            }
                            KClassImpl$Data$declaredNonStaticMembers$2();
                        } catch (JSONException e15) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad event bindings received", e15);
                        }
                        return;
                    case 7:
                        String str = (String) message.obj;
                        EditorConnection editorConnection3 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (editorConnection3 != null && editorConnection3.BuiltInFictitiousFunctionClassFactory() && this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext()) {
                            JsonWriter jsonWriter3 = new JsonWriter(new OutputStreamWriter(new BufferedOutputStream(new EditorConnection.WebSocketOutputStream(this.NetworkUserEntityData$$ExternalSyntheticLambda0, b))));
                            try {
                                try {
                                    jsonWriter3.beginObject();
                                    jsonWriter3.name("type").value("track_message");
                                    jsonWriter3.name("payload");
                                    jsonWriter3.beginObject();
                                    jsonWriter3.name("event_name").value(str);
                                    jsonWriter3.endObject();
                                    jsonWriter3.endObject();
                                    jsonWriter3.flush();
                                } catch (IOException e16) {
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e16);
                                }
                                try {
                                    jsonWriter3.close();
                                } catch (IOException e17) {
                                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't close writer.", e17);
                                }
                            } finally {
                            }
                        }
                        return;
                    case 8:
                        this.scheduleImpl.clear();
                        this.moveToNextValue.clear();
                        this.getErrorConfigVersion.clear();
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.addAll(this.GetContactSyncConfig);
                        this.GetContactSyncConfig.clear();
                        this.newProxyInstance = null;
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Editor closed- freeing snapshot");
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        for (String str2 : this.KClassImpl$Data$declaredNonStaticMembers$2) {
                            File PlaceComponentResult = this.NetworkUserEntityData$$ExternalSyntheticLambda1.PlaceComponentResult(str2);
                            if (PlaceComponentResult != null) {
                                PlaceComponentResult.delete();
                                synchronized (ImageStore.BuiltInFictitiousFunctionClassFactory) {
                                    ImageStore.BuiltInFictitiousFunctionClassFactory.remove(str2);
                                }
                            }
                        }
                        return;
                    case 9:
                        JSONArray jSONArray4 = (JSONArray) message.obj;
                        SharedPreferences.Editor edit2 = BuiltInFictitiousFunctionClassFactory().edit();
                        edit2.putString("mixpanel.viewcrawler.changes", jSONArray4.toString());
                        edit2.apply();
                        BuiltInFictitiousFunctionClassFactory(jSONArray4.toString(), true);
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    case 10:
                        try {
                            JSONArray jSONArray5 = ((JSONObject) message.obj).getJSONObject("payload").getJSONArray("actions");
                            for (int i7 = 0; i7 < jSONArray5.length(); i7++) {
                                this.scheduleImpl.remove(jSONArray5.getString(i7));
                            }
                        } catch (JSONException e18) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad clear request received", e18);
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    case 11:
                        try {
                            JSONArray jSONArray6 = ((JSONObject) message.obj).getJSONObject("payload").getJSONArray("tweaks");
                            int length2 = jSONArray6.length();
                            for (int i8 = 0; i8 < length2; i8++) {
                                MPPair<String, Object> KClassImpl$Data$declaredNonStaticMembers$2 = EditProtocol.KClassImpl$Data$declaredNonStaticMembers$2(jSONArray6.getJSONObject(i8));
                                this.getErrorConfigVersion.put(KClassImpl$Data$declaredNonStaticMembers$2.first, KClassImpl$Data$declaredNonStaticMembers$2);
                            }
                        } catch (EditProtocol.BadInstructionsException e19) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad tweaks received", e19);
                        } catch (JSONException e20) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad tweaks received", e20);
                        }
                        KClassImpl$Data$declaredNonStaticMembers$2();
                        return;
                    case 12:
                        ViewVisitor.LayoutErrorMessage layoutErrorMessage = (ViewVisitor.LayoutErrorMessage) message.obj;
                        EditorConnection editorConnection4 = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
                        if (editorConnection4 != null && editorConnection4.BuiltInFictitiousFunctionClassFactory() && this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext()) {
                            JsonWriter jsonWriter4 = new JsonWriter(new OutputStreamWriter(new BufferedOutputStream(new EditorConnection.WebSocketOutputStream(this.NetworkUserEntityData$$ExternalSyntheticLambda0, b))));
                            try {
                                try {
                                    jsonWriter4.beginObject();
                                    jsonWriter4.name("type").value("layout_error");
                                    jsonWriter4.name("exception_type").value(layoutErrorMessage.KClassImpl$Data$declaredNonStaticMembers$2);
                                    jsonWriter4.name("cid").value(layoutErrorMessage.PlaceComponentResult);
                                    jsonWriter4.endObject();
                                } finally {
                                }
                            } catch (IOException e21) {
                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't write track_message to server", e21);
                            }
                            try {
                                jsonWriter4.close();
                            } catch (IOException e22) {
                                MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't close writer.", e22);
                            }
                        }
                        return;
                    case 13:
                        JSONArray jSONArray7 = (JSONArray) message.obj;
                        SharedPreferences.Editor edit3 = BuiltInFictitiousFunctionClassFactory().edit();
                        edit3.putString("mixpanel.viewcrawler.changes", jSONArray7.toString());
                        edit3.apply();
                        return;
                    default:
                        return;
                }
            } finally {
                this.PlaceComponentResult.unlock();
            }
        }

        private void BuiltInFictitiousFunctionClassFactory(String str, boolean z) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    int length = jSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        MPPair<Integer, Integer> mPPair = new MPPair<>(Integer.valueOf(jSONObject.getInt("experiment_id")), Integer.valueOf(jSONObject.getInt("id")));
                        JSONArray jSONArray2 = jSONObject.getJSONArray("actions");
                        int length2 = jSONArray2.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            JSONObject jSONObject2 = jSONArray2.getJSONObject(i2);
                            this.getAuthRequestContext.add(new VariantChange(jSONObject2.getString("name"), JSONUtils.PlaceComponentResult(jSONObject2, "target_activity"), jSONObject2, mPPair));
                        }
                        JSONArray jSONArray3 = jSONObject.getJSONArray("tweaks");
                        int length3 = jSONArray3.length();
                        for (int i3 = 0; i3 < length3; i3++) {
                            JSONObject jSONObject3 = jSONArray3.getJSONObject(i3);
                            this.BuiltInFictitiousFunctionClassFactory.add(new VariantTweak(jSONObject3.getString("name"), jSONObject3, mPPair));
                        }
                        if (!z) {
                            this.DatabaseTableConfigUtil.add(mPPair);
                        }
                        if (length3 == 0 && length2 == 0) {
                            this.lookAheadTest.add(mPPair);
                        }
                    }
                } catch (JSONException e) {
                    MPLog.PlaceComponentResult("MixpanelAPI.ViewCrawler", "JSON error when loading ab tests / tweaks, clearing persistent memory", e);
                    SharedPreferences.Editor edit = BuiltInFictitiousFunctionClassFactory().edit();
                    edit.remove("mixpanel.viewcrawler.changes");
                    edit.apply();
                }
            }
        }

        private void BuiltInFictitiousFunctionClassFactory(String str) {
            if (str != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    this.NetworkUserEntityData$$ExternalSyntheticLambda2.clear();
                    for (int i = 0; i < jSONArray.length(); i++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        this.NetworkUserEntityData$$ExternalSyntheticLambda2.add(new MPPair<>(JSONUtils.PlaceComponentResult(jSONObject, "target_activity"), jSONObject));
                    }
                } catch (JSONException e) {
                    MPLog.PlaceComponentResult("MixpanelAPI.ViewCrawler", "JSON error when loading event bindings, clearing persistent memory", e);
                    SharedPreferences.Editor edit = BuiltInFictitiousFunctionClassFactory().edit();
                    edit.remove("mixpanel.viewcrawler.bindings");
                    edit.apply();
                }
            }
        }

        private void getAuthRequestContext(String str) {
            EditorConnection editorConnection = this.NetworkUserEntityData$$ExternalSyntheticLambda0;
            if (editorConnection != null && editorConnection.BuiltInFictitiousFunctionClassFactory() && this.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext()) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(TrackerKey.Property.ERROR_MESSAGE_FIREBASE, str);
                } catch (JSONException e) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Apparently impossible JSONException", e);
                }
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new BufferedOutputStream(new EditorConnection.WebSocketOutputStream(this.NetworkUserEntityData$$ExternalSyntheticLambda0, (byte) 0)));
                try {
                    try {
                        try {
                            outputStreamWriter.write("{\"type\": \"error\", ");
                            outputStreamWriter.write("\"payload\": ");
                            outputStreamWriter.write(jSONObject.toString());
                            outputStreamWriter.write("}");
                            outputStreamWriter.close();
                        } catch (IOException e2) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Can't write error message to editor", e2);
                            outputStreamWriter.close();
                        }
                    } catch (Throwable th) {
                        try {
                            outputStreamWriter.close();
                        } catch (IOException e3) {
                            MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e3);
                        }
                        throw th;
                    }
                } catch (IOException e4) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Could not close output writer to editor", e4);
                }
            }
        }

        private void KClassImpl$Data$declaredNonStaticMembers$2() {
            List arrayList;
            ArrayList arrayList2 = new ArrayList();
            HashSet<MPPair> hashSet = new HashSet();
            HashSet hashSet2 = new HashSet();
            for (VariantChange variantChange : this.getAuthRequestContext) {
                try {
                    arrayList2.add(new MPPair(variantChange.getAuthRequestContext, this.initRecordTimeStamp.MyBillsEntityDataFactory(variantChange.KClassImpl$Data$declaredNonStaticMembers$2).BuiltInFictitiousFunctionClassFactory));
                    if (!this.DatabaseTableConfigUtil.contains(variantChange.MyBillsEntityDataFactory)) {
                        hashSet.add(variantChange.MyBillsEntityDataFactory);
                    }
                } catch (EditProtocol.CantGetEditAssetsException e) {
                    MPLog.MyBillsEntityDataFactory("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e);
                } catch (EditProtocol.InapplicableInstructionsException e2) {
                    MPLog.MyBillsEntityDataFactory("MixpanelAPI.ViewCrawler", e2.getMessage());
                } catch (EditProtocol.BadInstructionsException e3) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad persistent change request cannot be applied.", e3);
                }
            }
            for (VariantTweak variantTweak : this.BuiltInFictitiousFunctionClassFactory) {
                try {
                    MPPair<String, Object> KClassImpl$Data$declaredNonStaticMembers$2 = EditProtocol.KClassImpl$Data$declaredNonStaticMembers$2(variantTweak.KClassImpl$Data$declaredNonStaticMembers$2);
                    if (this.DatabaseTableConfigUtil.contains(variantTweak.MyBillsEntityDataFactory)) {
                        if (ViewCrawler.this.moveToNextValue.MyBillsEntityDataFactory((String) KClassImpl$Data$declaredNonStaticMembers$2.first, KClassImpl$Data$declaredNonStaticMembers$2.second)) {
                            hashSet2.add(KClassImpl$Data$declaredNonStaticMembers$2.first);
                        }
                    } else {
                        hashSet.add(variantTweak.MyBillsEntityDataFactory);
                        hashSet2.add(KClassImpl$Data$declaredNonStaticMembers$2.first);
                    }
                    if (ViewCrawler.this.moveToNextValue.getAuthRequestContext().containsKey(KClassImpl$Data$declaredNonStaticMembers$2.first)) {
                        ViewCrawler.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2((String) KClassImpl$Data$declaredNonStaticMembers$2.first, KClassImpl$Data$declaredNonStaticMembers$2.second);
                    } else {
                        Tweaks.TweakValue PlaceComponentResult = Tweaks.TweakValue.PlaceComponentResult(variantTweak.KClassImpl$Data$declaredNonStaticMembers$2);
                        Tweaks tweaks = ViewCrawler.this.moveToNextValue;
                        String str = (String) KClassImpl$Data$declaredNonStaticMembers$2.first;
                        if (str != null && PlaceComponentResult != null) {
                            tweaks.PlaceComponentResult.put(str, PlaceComponentResult);
                        }
                    }
                } catch (EditProtocol.BadInstructionsException e4) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad editor tweak cannot be applied.", e4);
                }
            }
            if (this.BuiltInFictitiousFunctionClassFactory.size() == 0) {
                for (Map.Entry<String, Tweaks.TweakValue> entry : ViewCrawler.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2().entrySet()) {
                    Tweaks.TweakValue value = entry.getValue();
                    String key = entry.getKey();
                    if (ViewCrawler.this.moveToNextValue.MyBillsEntityDataFactory(key, value.getErrorConfigVersion)) {
                        ViewCrawler.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2(key, value.getErrorConfigVersion);
                        hashSet2.add(key);
                    }
                }
            }
            for (MPPair<String, JSONObject> mPPair : this.scheduleImpl.values()) {
                try {
                    EditProtocol.Edit MyBillsEntityDataFactory = this.initRecordTimeStamp.MyBillsEntityDataFactory((JSONObject) mPPair.second);
                    arrayList2.add(new MPPair(mPPair.first, MyBillsEntityDataFactory.BuiltInFictitiousFunctionClassFactory));
                    this.KClassImpl$Data$declaredNonStaticMembers$2.addAll(MyBillsEntityDataFactory.getAuthRequestContext);
                } catch (EditProtocol.BadInstructionsException e5) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad editor change request cannot be applied.", e5);
                } catch (EditProtocol.CantGetEditAssetsException e6) {
                    MPLog.MyBillsEntityDataFactory("MixpanelAPI.ViewCrawler", "Can't load assets for an edit, won't apply the change now", e6);
                } catch (EditProtocol.InapplicableInstructionsException e7) {
                    MPLog.MyBillsEntityDataFactory("MixpanelAPI.ViewCrawler", e7.getMessage());
                }
            }
            for (MPPair<String, Object> mPPair2 : this.getErrorConfigVersion.values()) {
                if (ViewCrawler.this.moveToNextValue.MyBillsEntityDataFactory((String) mPPair2.first, mPPair2.second)) {
                    hashSet2.add(mPPair2.first);
                }
                ViewCrawler.this.moveToNextValue.KClassImpl$Data$declaredNonStaticMembers$2((String) mPPair2.first, mPPair2.second);
            }
            if (this.moveToNextValue.size() == 0 && this.GetContactSyncConfig.size() == 0) {
                for (MPPair<String, JSONObject> mPPair3 : this.NetworkUserEntityData$$ExternalSyntheticLambda2) {
                    try {
                        arrayList2.add(new MPPair(mPPair3.first, this.initRecordTimeStamp.MyBillsEntityDataFactory((JSONObject) mPPair3.second, ViewCrawler.this.MyBillsEntityDataFactory)));
                    } catch (EditProtocol.InapplicableInstructionsException e8) {
                        MPLog.MyBillsEntityDataFactory("MixpanelAPI.ViewCrawler", e8.getMessage());
                    } catch (EditProtocol.BadInstructionsException e9) {
                        MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad persistent event binding cannot be applied.", e9);
                    }
                }
            }
            for (MPPair<String, JSONObject> mPPair4 : this.moveToNextValue.values()) {
                try {
                    arrayList2.add(new MPPair(mPPair4.first, this.initRecordTimeStamp.MyBillsEntityDataFactory((JSONObject) mPPair4.second, ViewCrawler.this.MyBillsEntityDataFactory)));
                } catch (EditProtocol.InapplicableInstructionsException e10) {
                    MPLog.MyBillsEntityDataFactory("MixpanelAPI.ViewCrawler", e10.getMessage());
                } catch (EditProtocol.BadInstructionsException e11) {
                    MPLog.KClassImpl$Data$declaredNonStaticMembers$2("MixpanelAPI.ViewCrawler", "Bad editor event binding cannot be applied.", e11);
                }
            }
            HashMap hashMap = new HashMap();
            int size = arrayList2.size();
            for (int i = 0; i < size; i++) {
                MPPair mPPair5 = (MPPair) arrayList2.get(i);
                if (hashMap.containsKey(mPPair5.first)) {
                    arrayList = (List) hashMap.get(mPPair5.first);
                } else {
                    arrayList = new ArrayList();
                    hashMap.put(mPPair5.first, arrayList);
                }
                arrayList.add(mPPair5.second);
            }
            EditState editState = ViewCrawler.this.KClassImpl$Data$declaredNonStaticMembers$2;
            synchronized (editState.PlaceComponentResult) {
                for (EditState.EditBinding editBinding : editState.PlaceComponentResult) {
                    editBinding.PlaceComponentResult = true;
                    editBinding.KClassImpl$Data$declaredNonStaticMembers$2.post(editBinding);
                }
                editState.PlaceComponentResult.clear();
            }
            synchronized (editState.getAuthRequestContext) {
                editState.getAuthRequestContext.clear();
                editState.getAuthRequestContext.putAll(hashMap);
            }
            editState.getAuthRequestContext();
            for (MPPair<Integer, Integer> mPPair6 : this.lookAheadTest) {
                if (!this.DatabaseTableConfigUtil.contains(mPPair6)) {
                    hashSet.add(mPPair6);
                }
            }
            this.DatabaseTableConfigUtil.addAll(hashSet);
            if (hashSet.size() > 0) {
                final JSONObject jSONObject = new JSONObject();
                try {
                    for (MPPair mPPair7 : hashSet) {
                        int intValue = ((Integer) mPPair7.first).intValue();
                        int intValue2 = ((Integer) mPPair7.second).intValue();
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("$experiment_id", intValue);
                        jSONObject2.put("$variant_id", intValue2);
                        jSONObject.put(Integer.toString(intValue), intValue2);
                        ViewCrawler.this.NetworkUserEntityData$$ExternalSyntheticLambda0.scheduleImpl.MyBillsEntityDataFactory("$experiments", jSONObject);
                        ViewCrawler.this.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult(new SuperPropertyUpdate() { // from class: com.mixpanel.android.viewcrawler.ViewCrawler.ViewCrawlerHandler.1
                            {
                                ViewCrawlerHandler.this = this;
                            }

                            @Override // com.mixpanel.android.mpmetrics.SuperPropertyUpdate
                            public final JSONObject MyBillsEntityDataFactory(JSONObject jSONObject3) {
                                try {
                                    jSONObject3.put("$experiments", jSONObject);
                                } catch (JSONException unused) {
                                    MPLog.MyBillsEntityDataFactory();
                                }
                                return jSONObject3;
                            }
                        });
                        ViewCrawler.this.NetworkUserEntityData$$ExternalSyntheticLambda0.KClassImpl$Data$declaredNonStaticMembers$2(ToggleEvent.EventName.GET_TOGGLE_CONFIG, jSONObject2);
                    }
                } catch (JSONException unused) {
                    MPLog.MyBillsEntityDataFactory();
                }
            }
            this.lookAheadTest.clear();
            if (hashSet2.size() > 0) {
                for (OnMixpanelTweaksUpdatedListener onMixpanelTweaksUpdatedListener : ViewCrawler.this.scheduleImpl) {
                }
            }
        }

        private SharedPreferences BuiltInFictitiousFunctionClassFactory() {
            StringBuilder sb = new StringBuilder();
            sb.append("mixpanel.viewcrawler.changes");
            sb.append(this.PrepareContext);
            return ViewCrawler.this.PlaceComponentResult.getSharedPreferences(sb.toString(), 0);
        }
    }

    /* loaded from: classes.dex */
    class Editor implements EditorConnection.Editor {
        private Editor() {
            ViewCrawler.this = r1;
        }

        /* synthetic */ Editor(ViewCrawler viewCrawler, byte b) {
            this();
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void KClassImpl$Data$declaredNonStaticMembers$2(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.getErrorConfigVersion.obtainMessage(2);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.getErrorConfigVersion.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void BuiltInFictitiousFunctionClassFactory(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.getErrorConfigVersion.obtainMessage(3);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.getErrorConfigVersion.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void PlaceComponentResult(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.getErrorConfigVersion.obtainMessage(10);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.getErrorConfigVersion.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void getAuthRequestContext(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.getErrorConfigVersion.obtainMessage(11);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.getErrorConfigVersion.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void MyBillsEntityDataFactory(JSONObject jSONObject) {
            Message obtainMessage = ViewCrawler.this.getErrorConfigVersion.obtainMessage(6);
            obtainMessage.obj = jSONObject;
            ViewCrawler.this.getErrorConfigVersion.sendMessage(obtainMessage);
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void KClassImpl$Data$declaredNonStaticMembers$2() {
            ViewCrawler.this.getErrorConfigVersion.sendMessage(ViewCrawler.this.getErrorConfigVersion.obtainMessage(4));
        }

        @Override // com.mixpanel.android.viewcrawler.EditorConnection.Editor
        public final void PlaceComponentResult() {
            ViewCrawler.this.getErrorConfigVersion.sendMessage(ViewCrawler.this.getErrorConfigVersion.obtainMessage(8));
        }
    }

    /* loaded from: classes.dex */
    public static class VariantChange {
        public final String BuiltInFictitiousFunctionClassFactory;
        public final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;
        public final MPPair<Integer, Integer> MyBillsEntityDataFactory;
        public final String getAuthRequestContext;

        public VariantChange(String str, String str2, JSONObject jSONObject, MPPair<Integer, Integer> mPPair) {
            this.BuiltInFictitiousFunctionClassFactory = str;
            this.getAuthRequestContext = str2;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject;
            this.MyBillsEntityDataFactory = mPPair;
        }

        public int hashCode() {
            return this.BuiltInFictitiousFunctionClassFactory.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof VariantChange) && obj.hashCode() == hashCode();
        }
    }

    /* loaded from: classes.dex */
    public static class VariantTweak {
        public final JSONObject KClassImpl$Data$declaredNonStaticMembers$2;
        public final MPPair<Integer, Integer> MyBillsEntityDataFactory;
        public final String PlaceComponentResult;

        public VariantTweak(String str, JSONObject jSONObject, MPPair<Integer, Integer> mPPair) {
            this.PlaceComponentResult = str;
            this.KClassImpl$Data$declaredNonStaticMembers$2 = jSONObject;
            this.MyBillsEntityDataFactory = mPPair;
        }

        public int hashCode() {
            return this.PlaceComponentResult.hashCode();
        }

        public boolean equals(Object obj) {
            return (obj instanceof VariantTweak) && obj.hashCode() == hashCode();
        }
    }
}
