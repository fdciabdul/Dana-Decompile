package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.log.BaseAppLog;
import com.alibaba.ariver.kernel.common.utils.StringUtils;

/* loaded from: classes3.dex */
public class EventLog extends BaseAppLog {

    /* renamed from: a  reason: collision with root package name */
    private String f6138a;
    private String b;

    private EventLog(Builder builder) {
        super(builder);
        this.f6138a = builder.f6139a;
        this.b = builder.b;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        String baseInfo = baseInfo();
        if (StringUtils.isEmpty(this.b)) {
            StringBuilder sb = new StringBuilder();
            sb.append(baseInfo);
            sb.append(this.f6138a);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(baseInfo);
        sb2.append(" ");
        sb2.append(this.b);
        sb2.append(" ");
        sb2.append(this.f6138a);
        return sb2.toString();
    }

    /* loaded from: classes3.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6139a;
        private String b;

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.EVENT);
            this.f6139a = "";
        }

        public Builder setData(String str) {
            this.f6139a = str;
            return getThis();
        }

        public Builder setEventName(String str) {
            this.b = str;
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new EventLog(this);
        }
    }
}
