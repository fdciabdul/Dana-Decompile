package com.bumptech.glide.load.model;

import android.text.TextUtils;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class LazyHeaders implements Headers {
    private volatile Map<String, String> KClassImpl$Data$declaredNonStaticMembers$2;
    private final Map<String, List<LazyHeaderFactory>> getAuthRequestContext;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LazyHeaders(Map<String, List<LazyHeaderFactory>> map) {
        this.getAuthRequestContext = Collections.unmodifiableMap(map);
    }

    @Override // com.bumptech.glide.load.model.Headers
    public final Map<String, String> BuiltInFictitiousFunctionClassFactory() {
        if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
            synchronized (this) {
                if (this.KClassImpl$Data$declaredNonStaticMembers$2 == null) {
                    HashMap hashMap = new HashMap();
                    for (Map.Entry<String, List<LazyHeaderFactory>> entry : this.getAuthRequestContext.entrySet()) {
                        List<LazyHeaderFactory> value = entry.getValue();
                        StringBuilder sb = new StringBuilder();
                        int size = value.size();
                        for (int i = 0; i < size; i++) {
                            String authRequestContext = value.get(i).getAuthRequestContext();
                            if (!TextUtils.isEmpty(authRequestContext)) {
                                sb.append(authRequestContext);
                                if (i != value.size() - 1) {
                                    sb.append(',');
                                }
                            }
                        }
                        String obj = sb.toString();
                        if (!TextUtils.isEmpty(obj)) {
                            hashMap.put(entry.getKey(), obj);
                        }
                    }
                    this.KClassImpl$Data$declaredNonStaticMembers$2 = Collections.unmodifiableMap(hashMap);
                }
            }
        }
        return this.KClassImpl$Data$declaredNonStaticMembers$2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LazyHeaders{headers=");
        sb.append(this.getAuthRequestContext);
        sb.append('}');
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof LazyHeaders) {
            return this.getAuthRequestContext.equals(((LazyHeaders) obj).getAuthRequestContext);
        }
        return false;
    }

    public final int hashCode() {
        return this.getAuthRequestContext.hashCode();
    }

    /* loaded from: classes3.dex */
    static final class StringHeaderFactory implements LazyHeaderFactory {
        private final String MyBillsEntityDataFactory;

        StringHeaderFactory(String str) {
            this.MyBillsEntityDataFactory = str;
        }

        @Override // com.bumptech.glide.load.model.LazyHeaderFactory
        public final String getAuthRequestContext() {
            return this.MyBillsEntityDataFactory;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("StringHeaderFactory{value='");
            sb.append(this.MyBillsEntityDataFactory);
            sb.append('\'');
            sb.append('}');
            return sb.toString();
        }

        public final boolean equals(Object obj) {
            if (obj instanceof StringHeaderFactory) {
                return this.MyBillsEntityDataFactory.equals(((StringHeaderFactory) obj).MyBillsEntityDataFactory);
            }
            return false;
        }

        public final int hashCode() {
            return this.MyBillsEntityDataFactory.hashCode();
        }
    }

    /* loaded from: classes3.dex */
    public static final class Builder {
        private static final String KClassImpl$Data$declaredNonStaticMembers$2;
        private static final Map<String, List<LazyHeaderFactory>> getAuthRequestContext;
        boolean PlaceComponentResult = true;
        Map<String, List<LazyHeaderFactory>> MyBillsEntityDataFactory = getAuthRequestContext;
        private boolean BuiltInFictitiousFunctionClassFactory = true;

        static {
            String property = System.getProperty("http.agent");
            if (!TextUtils.isEmpty(property)) {
                int length = property.length();
                StringBuilder sb = new StringBuilder(property.length());
                for (int i = 0; i < length; i++) {
                    char charAt = property.charAt(i);
                    if ((charAt > 31 || charAt == '\t') && charAt < 127) {
                        sb.append(charAt);
                    } else {
                        sb.append('?');
                    }
                }
                property = sb.toString();
            }
            KClassImpl$Data$declaredNonStaticMembers$2 = property;
            HashMap hashMap = new HashMap(2);
            if (!TextUtils.isEmpty(property)) {
                hashMap.put(HttpHeaders.USER_AGENT, Collections.singletonList(new StringHeaderFactory(property)));
            }
            getAuthRequestContext = Collections.unmodifiableMap(hashMap);
        }
    }
}
