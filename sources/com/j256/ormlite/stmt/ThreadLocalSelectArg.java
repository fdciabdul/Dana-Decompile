package com.j256.ormlite.stmt;

import com.j256.ormlite.field.SqlType;

/* loaded from: classes8.dex */
public class ThreadLocalSelectArg extends BaseArgumentHolder {
    private ThreadLocal<ValueWrapper> threadValue;

    public ThreadLocalSelectArg() {
        this.threadValue = new ThreadLocal<>();
    }

    public ThreadLocalSelectArg(String str, Object obj) {
        super(str);
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    public ThreadLocalSelectArg(SqlType sqlType, Object obj) {
        super(sqlType);
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    public ThreadLocalSelectArg(Object obj) {
        this.threadValue = new ThreadLocal<>();
        setValue(obj);
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    protected Object getValue() {
        ValueWrapper valueWrapper = this.threadValue.get();
        if (valueWrapper == null) {
            return null;
        }
        return valueWrapper.value;
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder, com.j256.ormlite.stmt.ArgumentHolder
    public void setValue(Object obj) {
        this.threadValue.set(new ValueWrapper(obj));
    }

    @Override // com.j256.ormlite.stmt.BaseArgumentHolder
    protected boolean isValueSet() {
        return this.threadValue.get() != null;
    }

    /* loaded from: classes8.dex */
    static class ValueWrapper {
        Object value;

        public ValueWrapper(Object obj) {
            this.value = obj;
        }
    }
}
