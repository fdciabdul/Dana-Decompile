package com.iap.ac.android.acs.plugin.biz.region.stageinfo.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class StageInfo {
    public List<StageContentInfo> contentInfoList;
    public String displayName;
    public Map<String, Object> layoutConfig = new HashMap();
    public String stageCode;
    public String stageType;
    public List<StageInfo> subStageList;
}
