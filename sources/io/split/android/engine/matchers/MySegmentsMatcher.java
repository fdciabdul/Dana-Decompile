package io.split.android.engine.matchers;

import io.split.android.client.Evaluator;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import java.util.Map;

/* loaded from: classes6.dex */
public class MySegmentsMatcher implements Matcher {
    private final MySegmentsStorage BuiltInFictitiousFunctionClassFactory;
    private final String KClassImpl$Data$declaredNonStaticMembers$2;

    public MySegmentsMatcher(MySegmentsStorage mySegmentsStorage, String str) {
        this.BuiltInFictitiousFunctionClassFactory = mySegmentsStorage;
        this.KClassImpl$Data$declaredNonStaticMembers$2 = str;
    }

    @Override // io.split.android.engine.matchers.Matcher
    public final boolean KClassImpl$Data$declaredNonStaticMembers$2(Object obj, String str, Map<String, Object> map, Evaluator evaluator) {
        return this.BuiltInFictitiousFunctionClassFactory.getAll().contains(this.KClassImpl$Data$declaredNonStaticMembers$2);
    }
}
