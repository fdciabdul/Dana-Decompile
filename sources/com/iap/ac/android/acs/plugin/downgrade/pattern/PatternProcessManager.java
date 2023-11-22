package com.iap.ac.android.acs.plugin.downgrade.pattern;

import com.iap.ac.android.acs.plugin.downgrade.pattern.impl.EncodePatternProcessor;
import com.iap.ac.android.acs.plugin.downgrade.pattern.impl.PlaceholderPatternProcessor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class PatternProcessManager {
    public static final PatternProcessManager INSTANCE = new PatternProcessManager();
    public final List<IPatternProcessor> mPatternProcessors;

    public PatternProcessManager() {
        ArrayList arrayList = new ArrayList();
        this.mPatternProcessors = arrayList;
        arrayList.add(new PlaceholderPatternProcessor());
        arrayList.add(new EncodePatternProcessor());
    }

    public String processKeyword(String str, JSONObject jSONObject) {
        Iterator<IPatternProcessor> it = this.mPatternProcessors.iterator();
        while (it.hasNext()) {
            str = it.next().process(str, jSONObject);
        }
        return str;
    }
}
