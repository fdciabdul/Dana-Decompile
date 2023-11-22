package com.bumptech.glide.manager;

import com.bumptech.glide.request.Request;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public class RequestTracker {
    public boolean MyBillsEntityDataFactory;
    public final Set<Request> KClassImpl$Data$declaredNonStaticMembers$2 = Collections.newSetFromMap(new WeakHashMap());
    public final List<Request> BuiltInFictitiousFunctionClassFactory = new ArrayList();

    public final boolean PlaceComponentResult(Request request) {
        boolean z = true;
        if (request == null) {
            return true;
        }
        boolean remove = this.KClassImpl$Data$declaredNonStaticMembers$2.remove(request);
        if (!this.BuiltInFictitiousFunctionClassFactory.remove(request) && !remove) {
            z = false;
        }
        if (z) {
            request.KClassImpl$Data$declaredNonStaticMembers$2();
        }
        return z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("{numRequests=");
        sb.append(this.KClassImpl$Data$declaredNonStaticMembers$2.size());
        sb.append(", isPaused=");
        sb.append(this.MyBillsEntityDataFactory);
        sb.append("}");
        return sb.toString();
    }
}
