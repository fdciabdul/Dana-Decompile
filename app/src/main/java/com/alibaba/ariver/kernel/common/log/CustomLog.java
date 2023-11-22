package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.log.BaseAppLog;

/* loaded from: classes6.dex */
public class CustomLog extends BaseAppLog {

    /* renamed from: a  reason: collision with root package name */
    private String f6136a;
    private String b;

    private CustomLog(Builder builder) {
        super(builder);
        this.f6136a = builder.f6137a;
        this.b = builder.b;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getBizType());
        sb.append(", ");
        sb.append(getLogType().getTypeSting());
        sb.append(", ");
        sb.append(getParentId());
        sb.append(", ");
        sb.append(this.f6136a);
        sb.append(", ");
        sb.append(this.b);
        return sb.toString();
    }

    /* loaded from: classes6.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6137a;
        private String b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.CUSTOM);
        }

        public Builder setLogId(String str) {
            this.f6137a = str;
            return getThis();
        }

        public Builder setMessage(String str) {
            this.b = str;
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new CustomLog(this);
        }
    }
}
