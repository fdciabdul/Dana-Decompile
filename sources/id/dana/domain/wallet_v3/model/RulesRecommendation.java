package id.dana.domain.wallet_v3.model;

import id.dana.utils.foundation.logger.log.DanaLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0086\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0014B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\n\u001a\u00020\t2\b\u0010\b\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0004R\u0017\u0010\u0005\u001a\u00020\u00028\u0007¢\u0006\f\n\u0004\b\u0005\u0010\u0010\u001a\u0004\b\u0011\u0010\u0004"}, d2 = {"Lid/dana/domain/wallet_v3/model/RulesRecommendation;", "", "", "component1", "()Ljava/lang/String;", "rawSQL", "copy", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/RulesRecommendation;", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "toString", "Ljava/lang/String;", "getRawSQL", "<init>", "(Ljava/lang/String;)V", "Companion", "Builder"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class RulesRecommendation {
    private static final String ASSET = "ASSET";
    private static final String EQUALS = "==";
    private static final String LOWER_THAN = "<";
    private static final String LOWER_THAN_EQUALS = "<=";
    private static final String MORE_THAN = ">";
    private static final String MORE_THAN_EQUALS = ">=";
    private static final String NOT_EQUALS = "!=";
    private static final String SECTION = "SECTION";
    private final String rawSQL;

    public static /* synthetic */ RulesRecommendation copy$default(RulesRecommendation rulesRecommendation, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = rulesRecommendation.rawSQL;
        }
        return rulesRecommendation.copy(str);
    }

    /* renamed from: component1  reason: from getter */
    public final String getRawSQL() {
        return this.rawSQL;
    }

    public final RulesRecommendation copy(String rawSQL) {
        Intrinsics.checkNotNullParameter(rawSQL, "");
        return new RulesRecommendation(rawSQL);
    }

    public final boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof RulesRecommendation) && Intrinsics.areEqual(this.rawSQL, ((RulesRecommendation) other).rawSQL);
    }

    public final int hashCode() {
        return this.rawSQL.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("RulesRecommendation(rawSQL=");
        sb.append(this.rawSQL);
        sb.append(')');
        return sb.toString();
    }

    public RulesRecommendation(String str) {
        Intrinsics.checkNotNullParameter(str, "");
        this.rawSQL = str;
    }

    @JvmName(name = "getRawSQL")
    public final String getRawSQL() {
        return this.rawSQL;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\t\u0010\nJ'\u0010\r\u001a\u00020\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u0006\u0010\b\u001a\u00020\u0005H\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00002\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00002\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00002\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\u00002\b\u0010\u0018\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u0013J\u0017\u0010\u001b\u001a\u00020\u00002\b\u0010\u001a\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001b\u0010\u0013J\u0017\u0010\u001c\u001a\u00020\u00002\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u0013R4\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000b8\u0007@BX\u0086\u000e¢\u0006\f\n\u0004\b\f\u0010\u001e\u001a\u0004\b\u001f\u0010 R(\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010\u0007R(\u0010\u0015\u001a\u0004\u0018\u00010\u00142\b\u0010\u001d\u001a\u0004\u0018\u00010\u00148\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0015\u0010#\u001a\u0004\b$\u0010%R(\u0010\u0018\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b\u0018\u0010!\u001a\u0004\b&\u0010\u0007R(\u0010\u001a\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b\u001a\u0010!\u001a\u0004\b'\u0010\u0007R(\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\u001d\u001a\u0004\u0018\u00010\u00058\u0007@BX\u0087\u000e¢\u0006\f\n\u0004\b\b\u0010!\u001a\u0004\b(\u0010\u0007"}, d2 = {"Lid/dana/domain/wallet_v3/model/RulesRecommendation$Builder;", "", "Lid/dana/domain/wallet_v3/model/RulesRecommendation;", "build", "()Lid/dana/domain/wallet_v3/model/RulesRecommendation;", "", "getRawSql", "()Ljava/lang/String;", "sectionType", "getSelectStatement", "(Ljava/lang/String;)Ljava/lang/String;", "", "assetTypes", "getWhereCause", "(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;", "setAssetTypes", "(Ljava/util/List;)Lid/dana/domain/wallet_v3/model/RulesRecommendation$Builder;", "baseOn", "setBaseOn", "(Ljava/lang/String;)Lid/dana/domain/wallet_v3/model/RulesRecommendation$Builder;", "", "comparator", "setComparator", "(Ljava/lang/Integer;)Lid/dana/domain/wallet_v3/model/RulesRecommendation$Builder;", "comparisonOperator", "setComparisonOperator", "logicalOperator", "setLogicalOperator", "setSectionType", "p0", "Ljava/util/List;", "getAssetTypes", "()Ljava/util/List;", "Ljava/lang/String;", "getBaseOn", "Ljava/lang/Integer;", "getComparator", "()Ljava/lang/Integer;", "getComparisonOperator", "getLogicalOperator", "getSectionType", "<init>", "()V"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Builder {
        private List<String> assetTypes;
        private String baseOn;
        private Integer comparator;
        private String comparisonOperator;
        private String logicalOperator;
        private String sectionType;

        @JvmName(name = "getBaseOn")
        public final String getBaseOn() {
            return this.baseOn;
        }

        @JvmName(name = "getAssetTypes")
        public final List<String> getAssetTypes() {
            return this.assetTypes;
        }

        @JvmName(name = "getSectionType")
        public final String getSectionType() {
            return this.sectionType;
        }

        @JvmName(name = "getLogicalOperator")
        public final String getLogicalOperator() {
            return this.logicalOperator;
        }

        @JvmName(name = "getComparisonOperator")
        public final String getComparisonOperator() {
            return this.comparisonOperator;
        }

        @JvmName(name = "getComparator")
        public final Integer getComparator() {
            return this.comparator;
        }

        public final Builder setBaseOn(String baseOn) {
            this.baseOn = baseOn;
            return this;
        }

        public final Builder setAssetTypes(List<String> assetTypes) {
            this.assetTypes = assetTypes;
            return this;
        }

        public final Builder setSectionType(String sectionType) {
            this.sectionType = sectionType;
            return this;
        }

        public final Builder setLogicalOperator(String logicalOperator) {
            this.logicalOperator = logicalOperator;
            return this;
        }

        public final Builder setComparisonOperator(String comparisonOperator) {
            this.comparisonOperator = comparisonOperator;
            return this;
        }

        public final Builder setComparator(Integer comparator) {
            this.comparator = comparator;
            return this;
        }

        public final RulesRecommendation build() {
            String rawSql = getRawSql();
            StringBuilder sb = new StringBuilder();
            sb.append("RawSQL for asset recommendation : ");
            sb.append(rawSql);
            DanaLog.MyBillsEntityDataFactory("WalletV3", sb.toString());
            return new RulesRecommendation(rawSql);
        }

        /* JADX WARN: Code restructure failed: missing block: B:5:0x0015, code lost:
        
            if (r1 == null) goto L6;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.String getRawSql() {
            /*
                Method dump skipped, instructions count: 260
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.model.RulesRecommendation.Builder.getRawSql():java.lang.String");
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
        
            if (r2.equals("PAYMENT") != false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x002b, code lost:
        
            if (r2.equals("VOUCHER_AND_TICKET") != false) goto L16;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x002d, code lost:
        
            return "SELECT pocketId FROM UserPocketAssetsDaoEntity ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x0036, code lost:
        
            if (r2.equals("FINANCIAL") != false) goto L19;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        
            return "SELECT uniqueId FROM UserPaymentAssetsDaoEntity ";
         */
        /* JADX WARN: Code restructure failed: missing block: B:6:0x000e, code lost:
        
            if (r2.equals("LOYALTY") != false) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.String getSelectStatement(java.lang.String r2) {
            /*
                r1 = this;
                int r0 = r2.hashCode()
                switch(r0) {
                    case -1150817175: goto L30;
                    case -554006299: goto L25;
                    case -68698650: goto L1c;
                    case 646865086: goto L11;
                    case 1076711462: goto L8;
                    default: goto L7;
                }
            L7:
                goto L3b
            L8:
                java.lang.String r0 = "LOYALTY"
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L3b
                goto L2d
            L11:
                java.lang.String r0 = "IDENTITY"
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L3b
                java.lang.String r2 = "SELECT pocketId FROM KtpDaoEntity "
                goto L3a
            L1c:
                java.lang.String r0 = "PAYMENT"
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L3b
                goto L38
            L25:
                java.lang.String r0 = "VOUCHER_AND_TICKET"
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L3b
            L2d:
                java.lang.String r2 = "SELECT pocketId FROM UserPocketAssetsDaoEntity "
                goto L3a
            L30:
                java.lang.String r0 = "FINANCIAL"
                boolean r2 = r2.equals(r0)
                if (r2 == 0) goto L3b
            L38:
                java.lang.String r2 = "SELECT uniqueId FROM UserPaymentAssetsDaoEntity "
            L3a:
                return r2
            L3b:
                id.dana.domain.wallet_v3.model.RulesRecommendationException$QueryNotAvailableException r2 = new id.dana.domain.wallet_v3.model.RulesRecommendationException$QueryNotAvailableException
                java.lang.String r0 = "Select query not available"
                r2.<init>(r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.model.RulesRecommendation.Builder.getSelectStatement(java.lang.String):java.lang.String");
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
        
            if (r11.equals("LOYALTY") == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
        
            if (r11.equals("PAYMENT") == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:29:0x0080, code lost:
        
            if (r11.equals("VOUCHER_AND_TICKET") != false) goto L30;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x0082, code lost:
        
            r6 = new java.lang.StringBuilder();
            r6.append("pocketType is '");
            r5 = r5.toUpperCase(java.util.Locale.ROOT);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "");
            r6.append(r5);
            r6.append("' ");
            r5 = r6.toString();
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a4, code lost:
        
            if (r11.equals("FINANCIAL") != false) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00a6, code lost:
        
            r6 = new java.lang.StringBuilder();
            r6.append("assetType is '");
            r5 = r5.toUpperCase(java.util.Locale.ROOT);
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "");
            r6.append(r5);
            r6.append("' ");
            r5 = r6.toString();
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private final java.lang.String getWhereCause(java.util.List<java.lang.String> r10, java.lang.String r11) {
            /*
                r9 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                r1 = r10
                java.util.Collection r1 = (java.util.Collection) r1
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L14
                boolean r1 = r1.isEmpty()
                if (r1 != 0) goto L14
                r1 = 0
                goto L15
            L14:
                r1 = 1
            L15:
                java.lang.String r4 = ""
                if (r1 != 0) goto Ld8
                java.lang.String r1 = "WHERE "
                r0.append(r1)
                r1 = r10
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r1 = r1.iterator()
            L25:
                boolean r5 = r1.hasNext()
                if (r5 == 0) goto Ld8
                java.lang.Object r5 = r1.next()
                if (r2 >= 0) goto L34
                kotlin.collections.CollectionsKt.throwIndexOverflow()
            L34:
                java.lang.String r5 = (java.lang.String) r5
                int r6 = r11.hashCode()
                java.lang.String r7 = "pocketType is '"
                java.lang.String r8 = "' "
                switch(r6) {
                    case -1150817175: goto L9e;
                    case -554006299: goto L7a;
                    case -68698650: goto L71;
                    case 646865086: goto L4d;
                    case 1076711462: goto L43;
                    default: goto L41;
                }
            L41:
                goto Lc4
            L43:
                java.lang.String r6 = "LOYALTY"
                boolean r6 = r11.equals(r6)
                if (r6 != 0) goto L82
                goto Lc4
            L4d:
                java.lang.String r6 = "IDENTITY"
                boolean r6 = r11.equals(r6)
                if (r6 == 0) goto Lc4
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r7)
                java.util.Locale r7 = java.util.Locale.ROOT
                java.lang.String r5 = r5.toUpperCase(r7)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
                r6.append(r5)
                r6.append(r8)
                java.lang.String r5 = r6.toString()
                goto Lc5
            L71:
                java.lang.String r6 = "PAYMENT"
                boolean r6 = r11.equals(r6)
                if (r6 != 0) goto La6
                goto Lc4
            L7a:
                java.lang.String r6 = "VOUCHER_AND_TICKET"
                boolean r6 = r11.equals(r6)
                if (r6 == 0) goto Lc4
            L82:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                r6.append(r7)
                java.util.Locale r7 = java.util.Locale.ROOT
                java.lang.String r5 = r5.toUpperCase(r7)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
                r6.append(r5)
                r6.append(r8)
                java.lang.String r5 = r6.toString()
                goto Lc5
            L9e:
                java.lang.String r6 = "FINANCIAL"
                boolean r6 = r11.equals(r6)
                if (r6 == 0) goto Lc4
            La6:
                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                r6.<init>()
                java.lang.String r7 = "assetType is '"
                r6.append(r7)
                java.util.Locale r7 = java.util.Locale.ROOT
                java.lang.String r5 = r5.toUpperCase(r7)
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)
                r6.append(r5)
                r6.append(r8)
                java.lang.String r5 = r6.toString()
                goto Lc5
            Lc4:
                r5 = r4
            Lc5:
                r0.append(r5)
                int r5 = r10.size()
                int r5 = r5 - r3
                if (r2 == r5) goto Ld4
                java.lang.String r5 = "OR "
                r0.append(r5)
            Ld4:
                int r2 = r2 + 1
                goto L25
            Ld8:
                java.lang.String r10 = r0.toString()
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)
                return r10
            */
            throw new UnsupportedOperationException("Method not decompiled: id.dana.domain.wallet_v3.model.RulesRecommendation.Builder.getWhereCause(java.util.List, java.lang.String):java.lang.String");
        }
    }
}
