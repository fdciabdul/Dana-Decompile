package com.alibaba.griver.base.nebula;

import android.util.LruCache;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.alibaba.griver.base.common.env.GriverEnv;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/* loaded from: classes3.dex */
public class H5PatternHelper {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f6323a = GriverEnv.isDebuggable();
    private static LruCache<String, Pattern> b = new LruCache<>(20);

    public static boolean matchRegex(String str, String str2) {
        Pattern compile;
        if (str == null || str2 == null || (compile = compile(str)) == null) {
            return false;
        }
        return compile.matcher(str2).matches();
    }

    public static Pattern compile(String str) {
        if (str == null) {
            return null;
        }
        Pattern pattern = b.get(str);
        if (pattern != null) {
            if (f6323a) {
                StringBuilder sb = new StringBuilder();
                sb.append("pattern cache hit: ");
                sb.append(str);
                RVLogger.d("H5PatternHelper", sb.toString());
            }
            return pattern;
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Pattern compile = Pattern.compile(str);
            b.put(str, compile);
            if (f6323a) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("pattern cache miss, use time: ");
                sb2.append(System.currentTimeMillis() - currentTimeMillis);
                sb2.append(" ");
                sb2.append(str);
                RVLogger.d("H5PatternHelper", sb2.toString());
            }
            return compile;
        } catch (PatternSyntaxException e) {
            StringBuilder sb3 = new StringBuilder();
            sb3.append("pattern ");
            sb3.append(str);
            sb3.append(" compile error!");
            RVLogger.e("H5PatternHelper", sb3.toString(), e);
            return null;
        }
    }
}
