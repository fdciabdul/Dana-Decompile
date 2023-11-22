package com.alibaba.ariver.kernel.common.log;

import com.alibaba.ariver.kernel.common.log.BaseAppLog;

/* loaded from: classes3.dex */
public class AppLog extends BaseAppLog {
    public static final String APP_LOG_APPEARANCE_FINISH = "appearance finish";
    public static final String APP_LOG_APPEARANCE_START = "appearance start";
    public static final String APP_LOG_ASYNC_UPDATE_FAIL = "async update fail";
    public static final String APP_LOG_ASYNC_UPDATE_FINISH = "async update finish";
    public static final String APP_LOG_ASYNC_UPDATE_START = "async update start";
    public static final String APP_LOG_CONTAINER_AWAKE = "container awake";
    public static final String APP_LOG_CONTAINER_FINISH = "container finish";
    public static final String APP_LOG_CONTAINER_START = "container start";
    public static final String APP_LOG_DECIDE_FAIL = "decide fail";
    public static final String APP_LOG_DECIDE_FINISH = "decide finish";
    public static final String APP_LOG_DECIDE_START = "decide start";
    public static final String APP_LOG_DOWNGRADE = "prepare downgrade";
    public static final String APP_LOG_PREPARE = "prepare ";
    public static final String APP_LOG_PREPARE_FAIL = "prepare fail";
    public static final String APP_LOG_PREPARE_FINISH = "prepare finish";

    /* renamed from: a  reason: collision with root package name */
    private String f6129a;
    private String b;

    private AppLog(Builder builder) {
        super(builder);
        this.f6129a = builder.b;
        this.b = builder.f6130a;
    }

    @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog
    public String toString() {
        String baseInfo = baseInfo();
        StringBuilder sb = new StringBuilder();
        sb.append(baseInfo);
        sb.append(" ");
        sb.append(this.f6129a);
        sb.append(", ");
        sb.append(this.b);
        return sb.toString();
    }

    /* loaded from: classes2.dex */
    public static class Builder extends BaseAppLog.Builder<Builder> {

        /* renamed from: a  reason: collision with root package name */
        private String f6130a;
        private String b;

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public Builder getThis() {
            return this;
        }

        public Builder() {
            super(LogType.APP);
            this.f6130a = "";
            this.b = "";
        }

        public Builder setDesc(String str) {
            this.f6130a = str;
            return getThis();
        }

        public Builder setAppId(String str) {
            this.b = str;
            return getThis();
        }

        @Override // com.alibaba.ariver.kernel.common.log.BaseAppLog.Builder
        public BaseAppLog build() {
            return new AppLog(this);
        }
    }
}
