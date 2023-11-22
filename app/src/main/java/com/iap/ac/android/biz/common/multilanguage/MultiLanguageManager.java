package com.iap.ac.android.biz.common.multilanguage;

import android.os.Handler;
import android.text.TextUtils;
import com.iap.ac.android.biz.common.ACManager;
import com.iap.ac.android.biz.common.callback.MultiLanguageCallback;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityQueryRpcResult;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CityRegionsGroupByInitial;
import com.iap.ac.android.biz.common.model.multilanguage.querycity.CountryRegion;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionCodeQueryRpcResult;
import com.iap.ac.android.biz.common.model.multilanguage.queryregioncode.RegionsGroupByInitial;
import com.iap.ac.android.biz.common.model.multilanguage.resources.Metadata;
import com.iap.ac.android.biz.common.multilanguage.network.MultiLanguageHttpClient;
import com.iap.ac.android.biz.common.multilanguage.repository.QueryCityRepository;
import com.iap.ac.android.biz.common.multilanguage.repository.QueryRegionCodeRepository;
import com.iap.ac.android.biz.common.utils.Utils;
import com.iap.ac.android.common.log.ACLog;
import com.iap.ac.android.common.task.async.IAPAsyncTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes8.dex */
public class MultiLanguageManager {
    public static final String TAG = "MultiLanguageManager";
    public static WeakReference<Handler> mHandlerWeakReference;

    public static Map<String, String> getI18nScene(String str, String str2, MultiLanguageHttpClient multiLanguageHttpClient) {
        Metadata metadata = multiLanguageHttpClient.getMetadata();
        if (metadata != null && metadata.lastest_versions != null && !TextUtils.isEmpty(metadata.static_url)) {
            String i18nScene = multiLanguageHttpClient.getI18nScene(metadata.static_url, str, metadata.lastest_versions.i18n.get(str), str2);
            HashMap hashMap = new HashMap();
            try {
                JSONObject jSONObject = new JSONObject(i18nScene);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.getString(next));
                }
                return hashMap;
            } catch (Throwable th) {
                ACLog.e(TAG, "getI18nScene exception,  errorCode is: ", th);
                return new HashMap();
            }
        }
        return new HashMap();
    }

    public static <T> void post(final MultiLanguageCallback<T> multiLanguageCallback, final T t) {
        WeakReference<Handler> weakReference = mHandlerWeakReference;
        if (weakReference == null || weakReference.get() == null) {
            mHandlerWeakReference = new WeakReference<>(new Handler(ACManager.getInstance().getContext().getMainLooper()));
        }
        mHandlerWeakReference.get().post(new Runnable() { // from class: com.iap.ac.android.biz.common.multilanguage.MultiLanguageManager.3
            @Override // java.lang.Runnable
            public final void run() {
                MultiLanguageCallback.this.onResult(t);
            }
        });
    }

    public static void queryBizSceneMultiLanguage(final String str, final String str2, final MultiLanguageCallback<Map<String, String>> multiLanguageCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.multilanguage.MultiLanguageManager.4
            @Override // java.lang.Runnable
            public final void run() {
                MultiLanguageManager.post(multiLanguageCallback, MultiLanguageManager.getI18nScene(str2, str, new MultiLanguageHttpClient(ACManager.getInstance().getContext())));
            }
        });
    }

    public static void queryCity(final String str, final List<String> list, final MultiLanguageCallback<List<CountryRegion>> multiLanguageCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.multilanguage.MultiLanguageManager.1
            @Override // java.lang.Runnable
            public final void run() {
                CityQueryRpcResult cityQueryRpcResult;
                try {
                    cityQueryRpcResult = new QueryCityRepository().queryCity(str, list);
                } catch (Throwable th) {
                    ACLog.e(MultiLanguageManager.TAG, String.format("queryCity error, e=%s", Utils.e(th)));
                    cityQueryRpcResult = null;
                }
                if (cityQueryRpcResult != null && cityQueryRpcResult.success) {
                    for (CountryRegion countryRegion : cityQueryRpcResult.countryWithCities) {
                        Iterator<CityRegionsGroupByInitial> it = countryRegion.cityRegionsGroupByInitials.iterator();
                        while (it.hasNext()) {
                            countryRegion.cities.addAll(it.next().cities);
                        }
                    }
                } else {
                    cityQueryRpcResult = new CityQueryRpcResult();
                }
                ArrayList arrayList = new ArrayList();
                for (CountryRegion countryRegion2 : cityQueryRpcResult.countryWithCities) {
                    if (countryRegion2.cities.size() != 0 && !TextUtils.isEmpty(countryRegion2.regionName) && !TextUtils.isEmpty(countryRegion2.regionCode)) {
                        arrayList.add(countryRegion2);
                    }
                }
                MultiLanguageManager.post(multiLanguageCallback, arrayList);
            }
        });
    }

    public static void queryRegionCode(final String str, final MultiLanguageCallback<List<RegionsGroupByInitial>> multiLanguageCallback) {
        IAPAsyncTask.asyncTask(new Runnable() { // from class: com.iap.ac.android.biz.common.multilanguage.MultiLanguageManager.2
            @Override // java.lang.Runnable
            public final void run() {
                RegionCodeQueryRpcResult regionCodeQueryRpcResult;
                try {
                    regionCodeQueryRpcResult = new QueryRegionCodeRepository().queryRegionCode(str);
                } catch (Throwable th) {
                    ACLog.e(MultiLanguageManager.TAG, String.format("queryRegionCode error, e=%s", Utils.e(th)));
                    regionCodeQueryRpcResult = null;
                }
                if (regionCodeQueryRpcResult == null || !regionCodeQueryRpcResult.success) {
                    regionCodeQueryRpcResult = new RegionCodeQueryRpcResult();
                }
                MultiLanguageManager.post(multiLanguageCallback, regionCodeQueryRpcResult.regionsGroupByInitials);
            }
        });
    }
}
