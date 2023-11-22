package com.alibaba.jsi.standard.java;

import com.alibaba.jsi.standard.J2JHelper;
import com.alibaba.jsi.standard.JSContext;
import com.alibaba.jsi.standard.js.EngineScope;
import com.alibaba.jsi.standard.js.JSValue;

/* loaded from: classes6.dex */
public class JavaSupport {
    private final JSContext mContext;
    private final J2JHelper mJ2JHelper;

    public JavaSupport(JSContext jSContext, J2JHelper j2JHelper) {
        this.mContext = jSContext;
        this.mJ2JHelper = j2JHelper;
    }

    public boolean addObject(String str, Object obj) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.addJavaObject(str, obj);
        } finally {
            engineScope.exit();
        }
    }

    public boolean removeObject(String str) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.removeJavaObject(str);
        } finally {
            engineScope.exit();
        }
    }

    public boolean detachObject(Object obj) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.detachJavaObject(obj);
        } finally {
            engineScope.exit();
        }
    }

    public boolean addClass(Class cls) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.addJavaClass(cls, null);
        } finally {
            engineScope.exit();
        }
    }

    public boolean addClass(Class cls, String str) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.addJavaClass(cls, str);
        } finally {
            engineScope.exit();
        }
    }

    public void enableImportClass() {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            this.mJ2JHelper.enableImportClass();
        } finally {
            engineScope.exit();
        }
    }

    public Object jsToJava(JSValue jSValue) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.jsToJava(this.mContext, jSValue);
        } finally {
            engineScope.exit();
        }
    }

    public JSValue javaToJS(Object obj) {
        EngineScope engineScope = new EngineScope(this.mContext.getJSEngine());
        try {
            return this.mJ2JHelper.javaToJS(this.mContext, obj);
        } finally {
            engineScope.exit();
        }
    }
}
