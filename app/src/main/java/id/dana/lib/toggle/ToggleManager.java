package id.dana.lib.toggle;

import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.fullstory.instrumentation.InstrumentInjector;
import id.dana.lib.toggle.factory.AbstractToggleFactory;
import id.dana.lib.toggle.result.RawResult;
import id.dana.lib.toggle.result.ToggleResult;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitResult;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class ToggleManager {
    private static final ToggleManager BuiltInFictitiousFunctionClassFactory = new ToggleManager();
    private ToggleManagerContract NetworkUserEntityData$$ExternalSyntheticLambda0;
    private Context getErrorConfigVersion;
    private Deserializer scheduleImpl;
    private final String KClassImpl$Data$declaredNonStaticMembers$2 = "split_cache";
    public final HashMap<String, Object> getAuthRequestContext = new HashMap<>();
    public final HashMap<String, AbstractToggleFactory> PlaceComponentResult = new HashMap<>();
    private final HashMap<String, CachedConfigModel> MyBillsEntityDataFactory = new HashMap<>();

    private ToggleManager() {
    }

    public static ToggleManager MyBillsEntityDataFactory() {
        ToggleManager toggleManager;
        synchronized (ToggleManager.class) {
            toggleManager = BuiltInFictitiousFunctionClassFactory;
        }
        return toggleManager;
    }

    public final void MyBillsEntityDataFactory(String str, final AbstractToggleFactory abstractToggleFactory) {
        if (abstractToggleFactory.moveToNextValue(null) != null) {
            abstractToggleFactory.moveToNextValue(null).on(SplitEvent.SDK_READY_FROM_CACHE, new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.2
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecutionView(SplitClient splitClient) {
                }

                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient splitClient) {
                    abstractToggleFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
            });
            abstractToggleFactory.moveToNextValue(null).on(SplitEvent.SDK_READY_TIMED_OUT, new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.3
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecutionView(SplitClient splitClient) {
                }

                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient splitClient) {
                    abstractToggleFactory.MyBillsEntityDataFactory = true;
                }
            });
            abstractToggleFactory.moveToNextValue(null).on(SplitEvent.SDK_READY, new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.4
                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecutionView(SplitClient splitClient) {
                }

                @Override // io.split.android.client.events.SplitEventTask
                public void onPostExecution(SplitClient splitClient) {
                    abstractToggleFactory.NetworkUserEntityData$$ExternalSyntheticLambda0 = true;
                }
            });
        }
        this.PlaceComponentResult.put(str, abstractToggleFactory);
    }

    public final void MyBillsEntityDataFactory(String str, final OnConfigUpdateListener onConfigUpdateListener) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str);
        if (abstractToggleFactory == null) {
            return;
        }
        abstractToggleFactory.moveToNextValue(null).on(SplitEvent.SDK_UPDATE, new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.5
            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecutionView(SplitClient splitClient) {
            }

            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecution(SplitClient splitClient) {
                OnConfigUpdateListener onConfigUpdateListener2 = onConfigUpdateListener;
                if (onConfigUpdateListener2 != null) {
                    onConfigUpdateListener2.KClassImpl$Data$declaredNonStaticMembers$2();
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private <T> T MyBillsEntityDataFactory(java.lang.String r3, java.lang.Class<T> r4, T r5) {
        /*
            r2 = this;
            if (r3 == 0) goto L18
            if (r4 == 0) goto L18
            id.dana.lib.toggle.result.ConfigResult r0 = new id.dana.lib.toggle.result.ConfigResult
            r0.<init>()
            java.lang.Object r3 = id.dana.lib.toggle.result.ConfigResult.MyBillsEntityDataFactory(r3, r4)     // Catch: com.alibaba.fastjson.JSONException -> Le
            goto L19
        Le:
            r0 = move-exception
            id.dana.lib.toggle.Deserializer r1 = r2.scheduleImpl
            if (r1 == 0) goto L18
            java.lang.Object r3 = r1.getAuthRequestContext(r3, r4, r0)
            goto L19
        L18:
            r3 = 0
        L19:
            if (r3 == 0) goto L1c
            r5 = r3
        L1c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: id.dana.lib.toggle.ToggleManager.MyBillsEntityDataFactory(java.lang.String, java.lang.Class, java.lang.Object):java.lang.Object");
    }

    public final SplitResult BuiltInFictitiousFunctionClassFactory(String str, String str2, String str3) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str2);
        if (abstractToggleFactory == null) {
            return null;
        }
        return abstractToggleFactory.moveToNextValue(str3).getTreatmentWithConfig(str, this.getAuthRequestContext);
    }

    /* renamed from: id.dana.lib.toggle.ToggleManager$6  reason: invalid class name */
    /* loaded from: classes2.dex */
    class AnonymousClass6 extends SplitEventTask {
        final /* synthetic */ RawResultCallback MyBillsEntityDataFactory;
        final /* synthetic */ String PlaceComponentResult;
        final /* synthetic */ ToggleManager getAuthRequestContext;

        @Override // io.split.android.client.events.SplitEventTask
        public void onPostExecutionView(SplitClient splitClient) {
        }

        @Override // io.split.android.client.events.SplitEventTask
        public void onPostExecution(SplitClient splitClient) {
            SplitResult treatmentWithConfig = splitClient.getTreatmentWithConfig(this.PlaceComponentResult, this.getAuthRequestContext.getAuthRequestContext);
            new RawResult(treatmentWithConfig.treatment(), treatmentWithConfig.config());
        }
    }

    public final void PlaceComponentResult(final List<String> list, String str, final RawResultsCallback rawResultsCallback, String str2) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str);
        if (abstractToggleFactory == null) {
            rawResultsCallback.onError();
            return;
        }
        SplitClient moveToNextValue = abstractToggleFactory.moveToNextValue(str2);
        if (PlaceComponentResult(str, str2)) {
            rawResultsCallback.onComplete(MyBillsEntityDataFactory(moveToNextValue.getTreatmentsWithConfig(list, this.getAuthRequestContext)));
            return;
        }
        SplitEventTask splitEventTask = new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.7
            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecutionView(SplitClient splitClient) {
            }

            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecution(SplitClient splitClient) {
                rawResultsCallback.onComplete(ToggleManager.MyBillsEntityDataFactory(splitClient.getTreatmentsWithConfig(list, ToggleManager.this.getAuthRequestContext)));
            }
        };
        moveToNextValue.on(SplitEvent.SDK_READY_FROM_CACHE, splitEventTask);
        moveToNextValue.on(SplitEvent.SDK_READY_TIMED_OUT, splitEventTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Map<String, RawResult> MyBillsEntityDataFactory(Map<String, SplitResult> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map.size());
        for (Map.Entry<String, SplitResult> entry : map.entrySet()) {
            SplitResult value = entry.getValue();
            linkedHashMap.put(entry.getKey(), new RawResult(value.treatment(), value.config()));
        }
        return linkedHashMap;
    }

    public final <T> void getAuthRequestContext(final String str, final String str2, final Class<T> cls, final T t, ToggleCallback<T> toggleCallback, final String str3) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str2);
        if (abstractToggleFactory == null) {
            toggleCallback.onError();
            return;
        }
        SplitClient moveToNextValue = abstractToggleFactory.moveToNextValue(str3);
        if (PlaceComponentResult(str2, str3)) {
            ToggleResult<T> MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, str2, cls, t, str3);
            toggleCallback.onComplete(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            return;
        }
        BuiltInFictitiousFunctionClassFactory(toggleCallback, this.MyBillsEntityDataFactory.get(str), cls, t);
        SplitEventTask splitEventTask = new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.8
            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecutionView(SplitClient splitClient) {
            }

            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecution(SplitClient splitClient) {
                ToggleResult MyBillsEntityDataFactory2 = ToggleManager.this.MyBillsEntityDataFactory(str, str2, cls, t, str3);
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" SDK Cache is fetched");
                InstrumentInjector.log_d("SplitToggle", sb.toString());
                ToggleManager.KClassImpl$Data$declaredNonStaticMembers$2(ToggleManager.this, str, MyBillsEntityDataFactory2.getAuthRequestContext, MyBillsEntityDataFactory2.KClassImpl$Data$declaredNonStaticMembers$2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(" config saved to memory");
                InstrumentInjector.log_d("SplitToggle", sb2.toString());
                ToggleManager.PlaceComponentResult(ToggleManager.this);
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str);
                sb3.append(" config saved to pref");
                InstrumentInjector.log_d("SplitToggle", sb3.toString());
            }
        };
        if (moveToNextValue == null) {
            toggleCallback.onComplete("control", t);
            return;
        }
        moveToNextValue.on(SplitEvent.SDK_READY_FROM_CACHE, splitEventTask);
        moveToNextValue.on(SplitEvent.SDK_READY_TIMED_OUT, splitEventTask);
    }

    public final <T> void KClassImpl$Data$declaredNonStaticMembers$2(final String str, final String str2, final Class<T> cls, final T t, final ToggleCallback<T> toggleCallback, final String str3) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str2);
        if (abstractToggleFactory == null) {
            toggleCallback.onError();
            return;
        }
        SplitClient moveToNextValue = abstractToggleFactory.moveToNextValue(str3);
        if (PlaceComponentResult(str2, str3)) {
            ToggleResult<T> MyBillsEntityDataFactory = MyBillsEntityDataFactory(str, str2, cls, t, str3);
            toggleCallback.onComplete(MyBillsEntityDataFactory.getAuthRequestContext, MyBillsEntityDataFactory.MyBillsEntityDataFactory);
            return;
        }
        SplitEventTask splitEventTask = new SplitEventTask() { // from class: id.dana.lib.toggle.ToggleManager.9
            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecutionView(SplitClient splitClient) {
            }

            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecution(SplitClient splitClient) {
                ToggleResult MyBillsEntityDataFactory2 = ToggleManager.this.MyBillsEntityDataFactory(str, str2, cls, t, str3);
                toggleCallback.onComplete(MyBillsEntityDataFactory2.getAuthRequestContext, MyBillsEntityDataFactory2.MyBillsEntityDataFactory);
            }
        };
        moveToNextValue.on(SplitEvent.SDK_READY_FROM_CACHE, splitEventTask);
        moveToNextValue.on(SplitEvent.SDK_READY_TIMED_OUT, splitEventTask);
    }

    private boolean PlaceComponentResult(String str, String str2) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str);
        if (abstractToggleFactory == null || abstractToggleFactory.moveToNextValue(str2) == null) {
            return false;
        }
        return abstractToggleFactory.moveToNextValue(str2).isReady() || abstractToggleFactory.KClassImpl$Data$declaredNonStaticMembers$2() || abstractToggleFactory.PlaceComponentResult();
    }

    public final RawResult MyBillsEntityDataFactory(String str, String str2, String str3) {
        SplitResult BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(str, str2, str3);
        if (BuiltInFictitiousFunctionClassFactory2 != null) {
            return new RawResult(BuiltInFictitiousFunctionClassFactory2.treatment(), BuiltInFictitiousFunctionClassFactory2.config());
        }
        return new RawResult();
    }

    public final Map<String, RawResult> PlaceComponentResult(List<String> list, String str, String str2) {
        Map<String, SplitResult> authRequestContext = getAuthRequestContext(list, str, str2);
        LinkedHashMap linkedHashMap = new LinkedHashMap(authRequestContext.size());
        for (Map.Entry<String, SplitResult> entry : authRequestContext.entrySet()) {
            SplitResult value = entry.getValue();
            if (value != null) {
                linkedHashMap.put(entry.getKey(), new RawResult(value.treatment(), value.config()));
            } else {
                linkedHashMap.put(entry.getKey(), new RawResult());
            }
        }
        return linkedHashMap;
    }

    private Map<String, SplitResult> getAuthRequestContext(List<String> list, String str, String str2) {
        AbstractToggleFactory abstractToggleFactory = this.PlaceComponentResult.get(str);
        if (abstractToggleFactory == null) {
            return Collections.emptyMap();
        }
        return abstractToggleFactory.moveToNextValue(str2).getTreatmentsWithConfig(list, this.getAuthRequestContext);
    }

    public final <T> ToggleResult<T> MyBillsEntityDataFactory(String str, String str2, Class<T> cls, T t, String str3) {
        SplitResult BuiltInFictitiousFunctionClassFactory2 = BuiltInFictitiousFunctionClassFactory(str, str2, str3);
        ToggleResult<T> toggleResult = new ToggleResult<>("control", t);
        if (BuiltInFictitiousFunctionClassFactory2 != null) {
            toggleResult.KClassImpl$Data$declaredNonStaticMembers$2 = BuiltInFictitiousFunctionClassFactory2.config();
            toggleResult.getAuthRequestContext = BuiltInFictitiousFunctionClassFactory2.treatment();
            toggleResult.MyBillsEntityDataFactory = (T) MyBillsEntityDataFactory(BuiltInFictitiousFunctionClassFactory2.config(), (Class<Class<T>>) cls, (Class<T>) t);
        }
        return toggleResult;
    }

    /* loaded from: classes2.dex */
    public static final class Builder {
        public Deserializer KClassImpl$Data$declaredNonStaticMembers$2;
        public ToggleManagerContract MyBillsEntityDataFactory;
        public String PlaceComponentResult;
        public Context getAuthRequestContext;
        public String getErrorConfigVersion;
        public String lookAheadTest;
        public String moveToNextValue;
        public String scheduleImpl;
        public final HashMap<String, Object> BuiltInFictitiousFunctionClassFactory = new HashMap<>();
        private final HashMap<String, AbstractToggleFactory> NetworkUserEntityData$$ExternalSyntheticLambda0 = new HashMap<>();
        private final HashMap<String, String> GetContactSyncConfig = new HashMap<>();
    }

    static /* synthetic */ void KClassImpl$Data$declaredNonStaticMembers$2(ToggleManager toggleManager, String str, String str2, String str3) {
        toggleManager.MyBillsEntityDataFactory.put(str, new CachedConfigModel(str2, str3));
    }

    static /* synthetic */ void PlaceComponentResult(ToggleManager toggleManager) {
        toggleManager.NetworkUserEntityData$$ExternalSyntheticLambda0.PlaceComponentResult("split_cache", JSON.toJSONString(toggleManager.MyBillsEntityDataFactory));
    }

    public static /* synthetic */ ToggleManager KClassImpl$Data$declaredNonStaticMembers$2(ToggleManager toggleManager, Builder builder) {
        toggleManager.getErrorConfigVersion = builder.getAuthRequestContext;
        toggleManager.getAuthRequestContext.put("android_lib_version", io.split.android.android_client.BuildConfig.SPLIT_VERSION_NAME);
        toggleManager.getAuthRequestContext.putAll(builder.BuiltInFictitiousFunctionClassFactory);
        for (Map.Entry entry : builder.NetworkUserEntityData$$ExternalSyntheticLambda0.entrySet()) {
            toggleManager.MyBillsEntityDataFactory((String) entry.getKey(), (AbstractToggleFactory) entry.getValue());
        }
        toggleManager.NetworkUserEntityData$$ExternalSyntheticLambda0 = builder.MyBillsEntityDataFactory;
        toggleManager.scheduleImpl = builder.KClassImpl$Data$declaredNonStaticMembers$2;
        synchronized (toggleManager) {
            try {
                toggleManager.MyBillsEntityDataFactory.putAll((HashMap) JSON.parseObject(toggleManager.NetworkUserEntityData$$ExternalSyntheticLambda0.getAuthRequestContext("split_cache"), new TypeReference<HashMap<String, CachedConfigModel>>() { // from class: id.dana.lib.toggle.ToggleManager.1
                }, new Feature[0]));
            } catch (Exception e) {
                StringBuilder sb = new StringBuilder();
                sb.append("Exception : ");
                sb.append(e);
                InstrumentInjector.log_d("ToggleSDK", sb.toString());
            }
        }
        return BuiltInFictitiousFunctionClassFactory;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> void BuiltInFictitiousFunctionClassFactory(ToggleCallback<T> toggleCallback, CachedConfigModel cachedConfigModel, Class<T> cls, T t) {
        if (cachedConfigModel != null) {
            toggleCallback.onComplete("_wrapper_cache", MyBillsEntityDataFactory(cachedConfigModel.MyBillsEntityDataFactory, (Class<Class<T>>) cls, (Class<T>) t));
        } else {
            toggleCallback.onComplete("control", null);
        }
    }
}
