package com.alibaba.ariver.kernel.common.log;

import android.text.TextUtils;

/* loaded from: classes3.dex */
public class BaseAppLog {

    /* renamed from: a  reason: collision with root package name */
    private String f6132a = AppLogger.getBizType();
    private LogType b;
    private String c;
    private String d;
    private String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getBizType() {
        return this.f6132a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LogType getLogType() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getParentId() {
        return this.c;
    }

    String getGroupId() {
        return this.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String getState() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseAppLog(Builder builder) {
        this.b = builder.d;
        this.c = builder.f6133a;
        this.d = builder.b;
        this.e = builder.c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String baseInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f6132a);
        sb.append(", ");
        sb.append(this.b.getTypeSting());
        sb.append(", ");
        sb.append(this.c);
        sb.append(", ");
        sb.append(this.d);
        sb.append(",");
        if (!TextUtils.isEmpty(this.e)) {
            sb.append(" ");
            sb.append(this.e);
        }
        return sb.toString();
    }

    public String toString() {
        return baseInfo();
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<T extends Builder<T>> {

        /* renamed from: a  reason: collision with root package name */
        private String f6133a;
        private String b = "-";
        private String c;
        private LogType d;

        public abstract BaseAppLog build();

        protected abstract T getThis();

        public Builder(LogType logType) {
            this.d = logType;
        }

        public T setParentId(String str) {
            this.f6133a = str;
            return getThis();
        }

        public T setGroupId(String str) {
            this.b = str;
            return getThis();
        }

        public T setState(String str) {
            this.c = str;
            return getThis();
        }
    }
}
