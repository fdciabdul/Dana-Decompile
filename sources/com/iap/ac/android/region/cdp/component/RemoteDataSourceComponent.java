package com.iap.ac.android.region.cdp.component;

import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface RemoteDataSourceComponent {
    Map<String, CdpSpaceInfo> batchQuerySpaceInfoMap(List<String> list, String str, String str2, Map<String, String> map) throws Exception;
}
