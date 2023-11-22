package com.alipay.mobile.framework.service.impl;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import com.alibaba.ariver.kernel.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.common.network.HttpRequest;
import com.alibaba.griver.api.common.network.HttpResponse;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.executor.GriverExecutors;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.network.GriverTransport;
import com.alibaba.griver.base.common.utils.MetaDataUtils;
import com.alibaba.griver.map.R;
import com.alipay.android.mapassist.util.Constants;
import com.alipay.mobile.beehive.poiselect.util.GooglePoiItem;
import com.alipay.mobile.beehive.poiselect.util.GooglePoiResult;
import com.alipay.mobile.framework.service.GeocodeService;
import com.alipay.mobile.framework.service.OnPoiSearchListener;
import com.alipay.mobile.framework.service.OnReGeocodeListener;
import com.alipay.mobile.map.exception.GeocodeException;
import com.alipay.mobile.map.model.LatLonPoint;
import com.alipay.mobile.map.model.SearchPoiRequest;
import com.alipay.mobile.map.model.geocode.GeocodeResult;
import com.alipay.mobile.map.model.geocode.PoiItem;
import com.alipay.mobile.map.model.geocode.ReGeocodeResult;
import com.alipay.mobile.map.model.multisearch.MultiSearchRequest;
import com.alipay.mobile.map.model.multisearch.MultiSearchResponse;
import com.alipay.mobile.map.model.weather.FutureWeatherResponse;
import com.alipay.mobile.map.model.weather.RealWeatherResponse;
import com.alipay.mobile.map.model.weather.WeatherRequest;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes6.dex */
public class GeocodeServiceImpl implements GeocodeService {

    /* renamed from: a  reason: collision with root package name */
    private String f7192a;
    private String b;

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void cityKeywordSearchPoi(Context context, String str, String str2, int i, int i2, OnPoiSearchListener onPoiSearchListener) {
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public FutureWeatherResponse getFutureWeatherResult(WeatherRequest weatherRequest) {
        return null;
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public MultiSearchResponse getMultiSearchResult(MultiSearchRequest multiSearchRequest) {
        return null;
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public RealWeatherResponse getRealWeatherResult(WeatherRequest weatherRequest) {
        return null;
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void searchpoi(Context context, String str, LatLonPoint latLonPoint, String str2, int i, int i2, OnPoiSearchListener onPoiSearchListener) {
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void searchpoi(Context context, String str, LatLonPoint latLonPoint, String str2, int i, int i2, OnPoiSearchListener onPoiSearchListener, int i3) {
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public List<GeocodeResult> geocode(String str) throws GeocodeException {
        return new ArrayList();
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public List<ReGeocodeResult> reGeocode(LatLonPoint latLonPoint, float f) throws GeocodeException {
        return reGeocode(latLonPoint, f, null);
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public List<ReGeocodeResult> reGeocode(LatLonPoint latLonPoint, float f, String str) throws GeocodeException {
        return new ArrayList();
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public ReGeocodeResult reverse(LatLonPoint latLonPoint, float f, String str) throws GeocodeException {
        return reverse(latLonPoint, f, str, 0);
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public ReGeocodeResult reverse(LatLonPoint latLonPoint, float f, String str, int i) throws GeocodeException {
        return new ReGeocodeResult();
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void reverse(LatLonPoint latLonPoint, float f, String str, OnReGeocodeListener onReGeocodeListener) throws GeocodeException {
        if (onReGeocodeListener != null) {
            onReGeocodeListener.onReGeocoded(reverse(latLonPoint, f, str, 0));
        }
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void reverse(LatLonPoint latLonPoint, float f, String str, int i, OnReGeocodeListener onReGeocodeListener) throws GeocodeException {
        if (onReGeocodeListener != null) {
            onReGeocodeListener.onReGeocoded(reverse(latLonPoint, f, str, i));
        }
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void searchpoi(Context context, LatLonPoint latLonPoint, String str, int i, int i2, OnPoiSearchListener onPoiSearchListener) {
        searchpoi(context, (String) null, latLonPoint, str, i, i2, onPoiSearchListener);
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void searchpoi(Context context, LatLonPoint latLonPoint, String str, int i, int i2, OnPoiSearchListener onPoiSearchListener, int i3) {
        searchpoi(context, null, latLonPoint, str, i, i2, onPoiSearchListener, i3);
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void searchpoi(Context context, OnPoiSearchListener onPoiSearchListener, SearchPoiRequest searchPoiRequest) {
        searchpoi(context, null, onPoiSearchListener, searchPoiRequest);
    }

    @Override // com.alipay.mobile.framework.service.GeocodeService
    public void searchpoi(Context context, String str, final OnPoiSearchListener onPoiSearchListener, final SearchPoiRequest searchPoiRequest) {
        StringBuilder sb = new StringBuilder();
        sb.append("searchpoi == ");
        sb.append(JSON.toJSONString(searchPoiRequest));
        GriverLogger.d("GeocodeServiceImpl", sb.toString());
        if (searchPoiRequest == null) {
            onPoiSearchListener.onPoiSearched(new LinkedList(), 0, 0);
            return;
        }
        if (TextUtils.isEmpty(this.b)) {
            this.b = MetaDataUtils.getMetaData(Constants.GOOGLE_MAP_KEY);
        }
        GriverExecutors.getExecutor(ExecutorType.NETWORK).execute(new Runnable() { // from class: com.alipay.mobile.framework.service.impl.GeocodeServiceImpl.1
            @Override // java.lang.Runnable
            public void run() {
                String format;
                HttpRequest httpRequest = new HttpRequest();
                if (searchPoiRequest.getPagenum() == 0) {
                    format = String.format(GriverEnv.getApplicationContext().getString(R.string.griver_map_poi_search_request), String.valueOf(searchPoiRequest.getLatlng().getLatitude()), String.valueOf(searchPoiRequest.getLatlng().getLongitude()), GeocodeServiceImpl.this.b);
                } else {
                    format = String.format(GriverEnv.getApplicationContext().getString(R.string.griver_map_poi_search_request_more), String.valueOf(searchPoiRequest.getLatlng().getLatitude()), String.valueOf(searchPoiRequest.getLatlng().getLongitude()), GeocodeServiceImpl.this.b, GeocodeServiceImpl.this.f7192a);
                }
                StringBuilder sb2 = new StringBuilder();
                sb2.append("url == ");
                sb2.append(format);
                GriverLogger.d("GeocodeServiceImpl", sb2.toString());
                httpRequest.setUrl(format);
                httpRequest.setMethod("GET");
                HttpResponse request = GriverTransport.request(httpRequest);
                if (request != null && request.getStatusCode() == 200) {
                    String read = IOUtils.read(request.getInputStream());
                    if (TextUtils.isEmpty(read)) {
                        return;
                    }
                    GooglePoiResult googlePoiResult = (GooglePoiResult) JSON.parseObject(read, GooglePoiResult.class);
                    GeocodeServiceImpl.this.f7192a = googlePoiResult.getNext_page_token();
                    if (googlePoiResult == null || googlePoiResult.getResults() == null) {
                        return;
                    }
                    final LinkedList linkedList = new LinkedList();
                    for (GooglePoiItem googlePoiItem : googlePoiResult.getResults()) {
                        PoiItem poiItem = new PoiItem();
                        poiItem.setLatLonPoint(new LatLonPoint(googlePoiItem.getGeometry().getLocation().getLat(), googlePoiItem.getGeometry().getLocation().getLng()));
                        poiItem.setTitle(googlePoiItem.getName());
                        poiItem.setSnippet(googlePoiItem.getVicinity());
                        poiItem.setPoiId(googlePoiItem.getPlace_id());
                        linkedList.add(poiItem);
                    }
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("size == ");
                    sb3.append(linkedList.size());
                    GriverLogger.d("GeocodeServiceImpl", sb3.toString());
                    if (onPoiSearchListener != null) {
                        ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.framework.service.impl.GeocodeServiceImpl.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                onPoiSearchListener.onPoiSearched(linkedList, searchPoiRequest.getPagenum(), searchPoiRequest.getPagesize());
                            }
                        });
                    }
                } else if (onPoiSearchListener != null) {
                    ExecutorUtils.runOnMain(new Runnable() { // from class: com.alipay.mobile.framework.service.impl.GeocodeServiceImpl.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            onPoiSearchListener.onPoiSearched(null, searchPoiRequest.getPagenum(), searchPoiRequest.getPagesize());
                        }
                    });
                }
            }
        });
    }
}
