package io.opentelemetry.instrumentation.api.db;

import com.alipay.android.phone.mobilesdk.socketcraft.monitor.MonitorItemConstants;
import com.alipay.iap.android.wallet.foundation.deeplink.DeeplinkService;
import com.ap.zoloz.hummer.connect.biz.HummerConnectConstants;
import id.dana.kyb.constant.KybServiceRedirectType;
import j$.util.Map;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes9.dex */
public final class RedisCommandSanitizer {
    private static final CommandSanitizer DEFAULT = new CommandAndNumArgs(0);
    private static final Map<String, CommandSanitizer> SANITIZERS;
    private final boolean statementSanitizationEnabled;

    /* loaded from: classes9.dex */
    interface CommandSanitizer {
        String sanitize(String str, List<?> list);
    }

    static {
        HashMap hashMap = new HashMap();
        CommandAndNumArgs commandAndNumArgs = new CommandAndNumArgs(1);
        CommandAndNumArgs commandAndNumArgs2 = new CommandAndNumArgs(2);
        MultiKeyValue multiKeyValue = new MultiKeyValue(1);
        MultiKeyValue multiKeyValue2 = new MultiKeyValue(0);
        Iterator it = Arrays.asList("CLUSTER", "FAILOVER", "READONLY", "READWRITE").iterator();
        while (it.hasNext()) {
            hashMap.put((String) it.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put(KybServiceRedirectType.AUTH, DEFAULT);
        hashMap.put("HELLO", commandAndNumArgs2);
        Iterator it2 = Arrays.asList("CLIENT", "ECHO", "PING", "QUIT", HummerConnectConstants.BIZ_SENCE_RESET, "SELECT").iterator();
        while (it2.hasNext()) {
            hashMap.put((String) it2.next(), KeepAllArgs.INSTANCE);
        }
        Iterator it3 = Arrays.asList("GEOADD", "GEODIST", "GEOHASH", "GEOPOS", "GEORADIUS", "GEORADIUS_RO", "GEORADIUSBYMEMBER", "GEORADIUSBYMEMBER_RO", "GEOSEARCH", "GEOSEARCHSTORE").iterator();
        while (it3.hasNext()) {
            hashMap.put((String) it3.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("HMSET", multiKeyValue);
        hashMap.put("HSET", multiKeyValue);
        hashMap.put("HSETNX", commandAndNumArgs2);
        Iterator it4 = Arrays.asList("HDEL", "HEXISTS", "HGET", "HGETALL", "HINCRBY", "HINCRBYFLOAT", "HKEYS", "HLEN", "HMGET", "HRANDFIELD", "HSCAN", "HSTRLEN", "HVALS").iterator();
        while (it4.hasNext()) {
            hashMap.put((String) it4.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("PFADD", commandAndNumArgs);
        Iterator it5 = Arrays.asList("PFCOUNT", "PFMERGE").iterator();
        while (it5.hasNext()) {
            hashMap.put((String) it5.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("MIGRATE", new CommandAndNumArgs(6));
        hashMap.put("RESTORE", commandAndNumArgs2);
        Iterator it6 = Arrays.asList("COPY", "DEL", "DUMP", "EXISTS", "EXPIRE", "EXPIREAT", "EXPIRETIME", "KEYS", "MOVE", "OBJECT", "PERSIST", "PEXPIRE", "PEXPIREAT", "PEXPIRETIME", "PTTL", "RANDOMKEY", "RENAME", "RENAMENX", DeeplinkService.Scene.SCAN, "SORT", "SORT_RO", "TOUCH", "TTL", "TYPE", "UNLINK", "WAIT").iterator();
        while (it6.hasNext()) {
            hashMap.put((String) it6.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("LINSERT", commandAndNumArgs2);
        hashMap.put("LPOS", commandAndNumArgs);
        hashMap.put("LPUSH", commandAndNumArgs);
        hashMap.put("LPUSHX", commandAndNumArgs);
        hashMap.put("LREM", commandAndNumArgs);
        hashMap.put("LSET", commandAndNumArgs);
        hashMap.put("RPUSH", commandAndNumArgs);
        hashMap.put("RPUSHX", commandAndNumArgs);
        Iterator it7 = Arrays.asList("BLMOVE", "BLMPOP", "BLPOP", "BRPOP", "BRPOPLPUSH", "LINDEX", "LLEN", "LMOVE", "LMPOP", "LPOP", "LRANGE", "LTRIM", "RPOP", "RPOPLPUSH").iterator();
        while (it7.hasNext()) {
            hashMap.put((String) it7.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("PUBLISH", commandAndNumArgs);
        Iterator it8 = Arrays.asList("PSUBSCRIBE", "PUBSUB", "PUNSUBSCRIBE", "SPUBLISH", "SSUBSCRIBE", "SUBSCRIBE", "SUNSUBSCRIBE", "UNSUBSCRIBE").iterator();
        while (it8.hasNext()) {
            hashMap.put((String) it8.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("EVAL", Eval.INSTANCE);
        hashMap.put("EVAL_RO", Eval.INSTANCE);
        hashMap.put("EVALSHA", Eval.INSTANCE);
        hashMap.put("EVALSHA_RO", Eval.INSTANCE);
        hashMap.put("SCRIPT", KeepAllArgs.INSTANCE);
        hashMap.put("CONFIG", commandAndNumArgs2);
        Iterator it9 = Arrays.asList("ACL", "BGREWRITEAOF", "BGSAVE", "COMMAND", "DBSIZE", "DEBUG", "FLUSHALL", "FLUSHDB", MonitorItemConstants.LEVEL_INFO, "LASTSAVE", "LATENCY", "LOLWUT", "MEMORY", "MODULE", "MONITOR", "PSYNC", "REPLICAOF", "ROLE", "SAVE", "SHUTDOWN", "SLAVEOF", "SLOWLOG", "SWAPDB", "SYNC", "TIME").iterator();
        while (it9.hasNext()) {
            hashMap.put((String) it9.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("SADD", commandAndNumArgs);
        hashMap.put("SISMEMBER", commandAndNumArgs);
        hashMap.put("SMISMEMBER", commandAndNumArgs);
        hashMap.put("SMOVE", commandAndNumArgs2);
        hashMap.put("SREM", commandAndNumArgs);
        Iterator it10 = Arrays.asList("SCARD", "SDIFF", "SDIFFSTORE", "SINTER", "SINTERCARD", "SINTERSTORE", "SMEMBERS", "SPOP", "SRANDMEMBER", "SSCAN", "SUNION", "SUNIONSTORE").iterator();
        while (it10.hasNext()) {
            hashMap.put((String) it10.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("ZADD", commandAndNumArgs);
        hashMap.put("ZCOUNT", commandAndNumArgs);
        hashMap.put("ZINCRBY", commandAndNumArgs);
        hashMap.put("ZLEXCOUNT", commandAndNumArgs);
        hashMap.put("ZMSCORE", commandAndNumArgs);
        hashMap.put("ZRANGEBYLEX", commandAndNumArgs);
        hashMap.put("ZRANGEBYSCORE", commandAndNumArgs);
        hashMap.put("ZRANK", commandAndNumArgs);
        hashMap.put("ZREM", commandAndNumArgs);
        hashMap.put("ZREMRANGEBYLEX", commandAndNumArgs);
        hashMap.put("ZREMRANGEBYSCORE", commandAndNumArgs);
        hashMap.put("ZREVRANGEBYLEX", commandAndNumArgs);
        hashMap.put("ZREVRANGEBYSCORE", commandAndNumArgs);
        hashMap.put("ZREVRANK", commandAndNumArgs);
        hashMap.put("ZSCORE", commandAndNumArgs);
        Iterator it11 = Arrays.asList("BZMPOP", "BZPOPMAX", "BZPOPMIN", "ZCARD", "ZDIFF", "ZDIFFSTORE", "ZINTER", "ZINTERCARD", "ZINTERSTORE", "ZMPOP", "ZPOPMAX", "ZPOPMIN", "ZRANDMEMBER", "ZRANGE", "ZRANGESTORE", "ZREMRANGEBYRANK", "ZREVRANGE", "ZSCAN", "ZUNION", "ZUNIONSTORE").iterator();
        while (it11.hasNext()) {
            hashMap.put((String) it11.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("XADD", new MultiKeyValue(2));
        Iterator it12 = Arrays.asList("XACK", "XAUTOCLAIM", "XCLAIM", "XDEL", "XGROUP", "XINFO", "XLEN", "XPENDING", "XRANGE", "XREAD", "XREADGROUP", "XREVRANGE", "XTRIM").iterator();
        while (it12.hasNext()) {
            hashMap.put((String) it12.next(), KeepAllArgs.INSTANCE);
        }
        hashMap.put("APPEND", commandAndNumArgs);
        hashMap.put("GETSET", commandAndNumArgs);
        hashMap.put("MSET", multiKeyValue2);
        hashMap.put("MSETNX", multiKeyValue2);
        hashMap.put("PSETEX", commandAndNumArgs2);
        hashMap.put("SET", commandAndNumArgs);
        hashMap.put("SETEX", commandAndNumArgs2);
        hashMap.put("SETNX", commandAndNumArgs);
        hashMap.put("SETRANGE", commandAndNumArgs);
        Iterator it13 = Arrays.asList("BITCOUNT", "BITFIELD", "BITFIELD_RO", "BITOP", "BITPOS", "DECR", "DECRBY", "GET", "GETBIT", "GETDEL", "GETEX", "GETRANGE", "INCR", "INCRBY", "INCRBYFLOAT", "LCS", "MGET", "SETBIT", "STRALGO", "STRLEN").iterator();
        while (it13.hasNext()) {
            hashMap.put((String) it13.next(), KeepAllArgs.INSTANCE);
        }
        Iterator it14 = Arrays.asList("DISCARD", "EXEC", "MULTI", "UNWATCH", "WATCH").iterator();
        while (it14.hasNext()) {
            hashMap.put((String) it14.next(), KeepAllArgs.INSTANCE);
        }
        SANITIZERS = Collections.unmodifiableMap(hashMap);
    }

    public static RedisCommandSanitizer create(boolean z) {
        return new RedisCommandSanitizer(z);
    }

    private RedisCommandSanitizer(boolean z) {
        this.statementSanitizationEnabled = z;
    }

    public final String sanitize(String str, List<?> list) {
        if (!this.statementSanitizationEnabled) {
            return KeepAllArgs.INSTANCE.sanitize(str, list);
        }
        return ((CommandSanitizer) Map.EL.KClassImpl$Data$declaredNonStaticMembers$2(SANITIZERS, str.toUpperCase(Locale.ROOT), DEFAULT)).sanitize(str, list);
    }

    /* loaded from: classes9.dex */
    enum KeepAllArgs implements CommandSanitizer {
        INSTANCE;

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public final String sanitize(String str, List<?> list) {
            StringBuilder sb = new StringBuilder(str);
            for (Object obj : list) {
                sb.append(" ");
                sb.append(RedisCommandSanitizer.argToString(obj));
            }
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    static final class CommandAndNumArgs implements CommandSanitizer {
        private final int numOfArgsToKeep;

        CommandAndNumArgs(int i) {
            this.numOfArgsToKeep = i;
        }

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public final String sanitize(String str, List<?> list) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < this.numOfArgsToKeep && i < list.size(); i++) {
                sb.append(" ");
                sb.append(RedisCommandSanitizer.argToString(list.get(i)));
            }
            for (int i2 = this.numOfArgsToKeep; i2 < list.size(); i2++) {
                sb.append(" ?");
            }
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    static final class MultiKeyValue implements CommandSanitizer {
        private final int numOfArgsBeforeKeyValue;

        MultiKeyValue(int i) {
            this.numOfArgsBeforeKeyValue = i;
        }

        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        public final String sanitize(String str, List<?> list) {
            StringBuilder sb = new StringBuilder(str);
            for (int i = 0; i < this.numOfArgsBeforeKeyValue && i < list.size(); i++) {
                sb.append(" ");
                sb.append(RedisCommandSanitizer.argToString(list.get(i)));
            }
            for (int i2 = this.numOfArgsBeforeKeyValue; i2 < list.size(); i2 += 2) {
                sb.append(" ");
                sb.append(RedisCommandSanitizer.argToString(list.get(i2)));
                sb.append(" ?");
            }
            return sb.toString();
        }
    }

    /* loaded from: classes9.dex */
    enum Eval implements CommandSanitizer {
        INSTANCE;

        /* JADX WARN: Removed duplicated region for block: B:15:0x003f A[LOOP:1: B:13:0x0039->B:15:0x003f, LOOP_END] */
        @Override // io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.CommandSanitizer
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.String sanitize(java.lang.String r4, java.util.List<?> r5) {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>(r4)
                int r4 = r5.size()
                r1 = 2
                r2 = 0
                if (r4 <= r1) goto L1b
                r4 = 1
                java.lang.Object r4 = r5.get(r4)     // Catch: java.lang.NumberFormatException -> L1b
                java.lang.String r4 = io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.argToString(r4)     // Catch: java.lang.NumberFormatException -> L1b
                int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.NumberFormatException -> L1b
                goto L1c
            L1b:
                r4 = 0
            L1c:
                int r1 = r4 + 2
                if (r2 >= r1) goto L39
                int r1 = r5.size()
                if (r2 >= r1) goto L39
                java.lang.String r1 = " "
                r0.append(r1)
                java.lang.Object r1 = r5.get(r2)
                java.lang.String r1 = io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.argToString(r1)
                r0.append(r1)
                int r2 = r2 + 1
                goto L1c
            L39:
                int r4 = r5.size()
                if (r2 >= r4) goto L47
                java.lang.String r4 = " ?"
                r0.append(r4)
                int r2 = r2 + 1
                goto L39
            L47:
                java.lang.String r4 = r0.toString()
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: io.opentelemetry.instrumentation.api.db.RedisCommandSanitizer.Eval.sanitize(java.lang.String, java.util.List):java.lang.String");
        }
    }

    static String argToString(Object obj) {
        if (obj instanceof byte[]) {
            return new String((byte[]) obj, StandardCharsets.UTF_8);
        }
        return String.valueOf(obj);
    }
}
