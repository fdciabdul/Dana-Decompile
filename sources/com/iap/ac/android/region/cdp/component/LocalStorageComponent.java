package com.iap.ac.android.region.cdp.component;

import com.iap.ac.android.region.cdp.model.CdpBehaviorInfo;
import com.iap.ac.android.region.cdp.model.CdpContentInfo;
import com.iap.ac.android.region.cdp.model.CdpFatigueInfo;
import com.iap.ac.android.region.cdp.model.CdpSpaceInfo;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public interface LocalStorageComponent {
    void deleteBehavior(CdpBehaviorInfo cdpBehaviorInfo) throws Exception;

    void deleteBehavior(String str, String str2) throws Exception;

    void deleteSpaceInfo(String str) throws Exception;

    void deleteSpaceInfo(Collection<String> collection, boolean z);

    CdpBehaviorInfo getBehaviorInfo(String str, String str2, String str3, String str4, String str5) throws Exception;

    List<CdpBehaviorInfo> getBehaviorInfo(String str, String str2, String str3) throws Exception;

    CdpContentInfo getContentInfo(String str, String str2, String str3) throws Exception;

    List<CdpFatigueInfo> getFatigueInfo(String str, String str2, String str3, String str4, String str5) throws Exception;

    CdpSpaceInfo getSpaceInfo(String str, String str2, String str3) throws Exception;

    Map<String, CdpSpaceInfo> getSpaceInfoMap(List<String> list, String str, String str2) throws Exception;

    void insertOrReplaceBehaviorInfo(CdpBehaviorInfo cdpBehaviorInfo) throws Exception;

    void insertOrReplaceBehaviorInfo(List<CdpBehaviorInfo> list) throws Exception;

    void insertOrReplaceSpaceInfo(CdpSpaceInfo cdpSpaceInfo) throws Exception;

    void insertOrReplaceSpaceInfo(Collection<CdpSpaceInfo> collection) throws Exception;
}
