package com.alibaba.jsi.standard;

import com.alibaba.jsi.standard.js.Deletable;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSArray;
import com.alibaba.jsi.standard.js.JSArrayBuffer;
import com.alibaba.jsi.standard.js.JSBooleanObject;
import com.alibaba.jsi.standard.js.JSException;
import com.alibaba.jsi.standard.js.JSFunction;
import com.alibaba.jsi.standard.js.JSMap;
import com.alibaba.jsi.standard.js.JSNumberObject;
import com.alibaba.jsi.standard.js.JSSet;
import com.alibaba.jsi.standard.js.JSStringObject;
import com.alibaba.jsi.standard.js.JSSymbol;
import com.alibaba.jsi.standard.js.JSSymbolObject;
import com.alibaba.jsi.standard.js.JSValue;
import com.alibaba.jsi.standard.js.JSWeakValue;
import com.alibaba.jsi.standard.js.Template;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes6.dex */
public class LeakUtil {
    private static final String TAG = "jsi";
    private static final Set<Deletable> sOutOfEngineObjects = new HashSet();
    private static AtomicInteger sEnableCounter = new AtomicInteger(0);
    private static boolean sEnableStat = false;
    private static boolean sEnabledEver = false;
    private static boolean sHasOutOfEngineObjects = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void statSwitchChanged(boolean z) {
        sEnableStat = sEnableCounter.addAndGet(z ? 1 : -1) > 0;
    }

    public static void add(JSContext jSContext, Deletable deletable) {
        if (sEnableStat) {
            if (jSContext == null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Pass null JSContext with object: ");
                sb.append(deletable);
                throw new NullPointerException(sb.toString());
            }
            sEnabledEver = true;
            jSContext.getJSEngine().objectCreated(deletable);
        }
    }

    public static void add(JSEngine jSEngine, Template template) {
        if (sEnableStat) {
            sEnabledEver = true;
            if (jSEngine != null) {
                jSEngine.objectCreated(template);
            }
        }
    }

    public static void add(Deletable deletable) {
        if (sEnableStat) {
            Set<Deletable> set = sOutOfEngineObjects;
            synchronized (set) {
                set.add(deletable);
                sHasOutOfEngineObjects = true;
            }
        }
    }

    public static void remove(JSContext jSContext, Deletable deletable) {
        if (sEnabledEver && jSContext != null) {
            jSContext.getJSEngine().objectDeleted(deletable);
        }
    }

    public static void remove(JSEngine jSEngine, Template template) {
        if (sEnabledEver && jSEngine != null) {
            jSEngine.objectDeleted(template);
        }
    }

    public static void remove(Deletable deletable) {
        if (sHasOutOfEngineObjects) {
            Set<Deletable> set = sOutOfEngineObjects;
            synchronized (set) {
                set.remove(deletable);
                sHasOutOfEngineObjects = set.size() != 0;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void printObjects(JSContext jSContext, Set<Deletable> set, String str, int i) {
        EngineScope engineScope;
        JSEngine jSEngine;
        EngineScope engineScope2;
        HashSet hashSet;
        HashSet hashSet2;
        if (sEnableStat) {
            HashSet hashSet3 = new HashSet();
            HashSet hashSet4 = new HashSet();
            HashSet hashSet5 = new HashSet();
            HashSet hashSet6 = new HashSet();
            HashSet hashSet7 = new HashSet();
            HashSet hashSet8 = new HashSet();
            HashSet hashSet9 = new HashSet();
            HashSet hashSet10 = new HashSet();
            HashSet hashSet11 = new HashSet();
            HashSet hashSet12 = new HashSet();
            HashSet hashSet13 = new HashSet();
            int size = set.size();
            Iterator<Deletable> it = set.iterator();
            while (it.hasNext()) {
                Deletable next = it.next();
                Iterator<Deletable> it2 = it;
                if (next instanceof JSSymbol) {
                    hashSet3.add(next);
                } else if (next instanceof JSArray) {
                    hashSet4.add(next);
                } else if (next instanceof JSArrayBuffer) {
                    hashSet5.add(next);
                } else if (next instanceof JSFunction) {
                    hashSet6.add(next);
                } else if (next instanceof JSMap) {
                    hashSet7.add(next);
                } else if (next instanceof JSSet) {
                    hashSet8.add(next);
                } else if ((next instanceof JSBooleanObject) || (next instanceof JSNumberObject) || (next instanceof JSStringObject) || (next instanceof JSSymbolObject)) {
                    hashSet9.add(next);
                } else if (next instanceof JSWeakValue) {
                    hashSet10.add(next);
                } else if (next instanceof JSException) {
                    hashSet13.add(next);
                } else if (next instanceof Template) {
                    hashSet12.add(next);
                } else {
                    hashSet11.add(next);
                }
                it = it2;
            }
            if (jSContext != null) {
                jSEngine = jSContext.getJSEngine();
                engineScope = new EngineScope(jSEngine);
            } else {
                engineScope = null;
                jSEngine = null;
            }
            try {
                log(" ");
                log("*** *** *** *** ***  Alive Java JS Objects  *** *** *** *** ***");
                engineScope2 = engineScope;
            } catch (Throwable th) {
                th = th;
                engineScope2 = engineScope;
            }
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("JSEngine: ");
                sb.append(str);
                log(sb.toString());
                if (jSEngine != null) {
                    List<JSContext> contexts = jSEngine.getContexts();
                    int min = Math.min(contexts.size(), i);
                    if (contexts.size() > 0) {
                        hashSet2 = hashSet12;
                        int i2 = 0;
                        hashSet = hashSet10;
                        log(String.format(Locale.US, "JSContext (%d of %d):", Integer.valueOf(min), Integer.valueOf(contexts.size())));
                        Iterator<JSContext> it3 = contexts.iterator();
                        while (it3.hasNext()) {
                            JSContext next2 = it3.next();
                            int i3 = i2 + 1;
                            if (i3 > min) {
                                break;
                            }
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("  * ");
                            sb2.append(next2.getTitle());
                            log(sb2.toString());
                            it3 = it3;
                            i2 = i3;
                        }
                    } else {
                        hashSet = hashSet10;
                        hashSet2 = hashSet12;
                        log("JSContext: none");
                    }
                } else {
                    hashSet = hashSet10;
                    hashSet2 = hashSet12;
                }
                StringBuilder sb3 = new StringBuilder();
                sb3.append("Objects count: ");
                sb3.append(size);
                log(sb3.toString());
                print(jSContext, hashSet3, "JSSymbol", i);
                print(jSContext, hashSet4, "JSArray", i);
                print(jSContext, hashSet5, "JSArrayBuffer", i);
                print(jSContext, hashSet6, "JSFunction", i);
                print(jSContext, hashSet7, "JSMap", i);
                print(jSContext, hashSet8, "JSSet", i);
                print(jSContext, hashSet9, "JSPrimitiveObject", i);
                print(jSContext, hashSet11, "JSObject", i);
                print(jSContext, hashSet, "JSWeakValue", i);
                print(jSContext, hashSet2, "Template", i);
                print(jSContext, hashSet13, "JSException", i);
                Set<Deletable> set2 = sOutOfEngineObjects;
                synchronized (set2) {
                    print(null, set2, "OutOfEngineObjects", i);
                }
                log("*** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***");
                log(" ");
                if (engineScope2 != null) {
                    engineScope2.exit();
                }
            } catch (Throwable th2) {
                th = th2;
                if (engineScope2 != null) {
                    engineScope2.exit();
                }
                throw th;
            }
        }
    }

    private static void print(JSContext jSContext, Set<Deletable> set, String str, int i) {
        if (set.size() == 0) {
            return;
        }
        int i2 = 0;
        log(String.format(Locale.US, "%s (%d of %d):", str, Integer.valueOf(Math.min(set.size(), i)), Integer.valueOf(set.size())));
        for (Deletable deletable : set) {
            i2++;
            if (i2 > i) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            sb.append("  * ");
            sb.append(deletable.toString());
            String obj = sb.toString();
            if (jSContext != null && (deletable instanceof JSValue)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(obj);
                sb2.append(" (");
                sb2.append(((JSValue) deletable).toString(jSContext));
                sb2.append(")");
                obj = sb2.toString();
            }
            log(obj);
        }
    }

    private static void log(String str) {
        OSUtil.w(str);
    }
}
