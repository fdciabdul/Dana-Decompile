package com.ap.zoloz.hummer.api;

import com.alibaba.fastjson.annotation.JSONField;
import com.ap.zoloz.hummer.common.UIConfig;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class TaskUIConfig {
    @JSONField(name = "tasks")
    public ArrayList<UIConfig> tasks = new ArrayList<>();
}
