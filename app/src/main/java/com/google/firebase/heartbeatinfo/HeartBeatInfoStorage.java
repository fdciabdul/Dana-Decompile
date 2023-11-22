package com.google.firebase.heartbeatinfo;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import j$.time.Instant;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class HeartBeatInfoStorage {
    private static final String GLOBAL = "fire-global";
    private static final String HEARTBEAT_PREFERENCES_NAME = "FirebaseHeartBeat";
    private static final int HEART_BEAT_COUNT_LIMIT = 30;
    private static final String HEART_BEAT_COUNT_TAG = "fire-count";
    private static final String LAST_STORED_DATE = "last-used-date";
    private static final String PREFERENCES_NAME = "FirebaseAppHeartBeat";
    private static HeartBeatInfoStorage instance;
    private final SharedPreferences firebaseSharedPreferences;

    public HeartBeatInfoStorage(Context context, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(HEARTBEAT_PREFERENCES_NAME);
        sb.append(str);
        this.firebaseSharedPreferences = context.getSharedPreferences(sb.toString(), 0);
    }

    HeartBeatInfoStorage(SharedPreferences sharedPreferences) {
        this.firebaseSharedPreferences = sharedPreferences;
    }

    int getHeartBeatCount() {
        return (int) this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void deleteAllHeartBeats() {
        synchronized (this) {
            SharedPreferences.Editor edit = this.firebaseSharedPreferences.edit();
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    edit.remove(entry.getKey());
                }
            }
            edit.remove(HEART_BEAT_COUNT_TAG);
            edit.commit();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<HeartBeatResult> getAllHeartBeats() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList();
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    arrayList.add(HeartBeatResult.create(entry.getKey(), new ArrayList((Set) entry.getValue())));
                }
            }
            updateGlobalHeartBeat(System.currentTimeMillis());
        }
        return arrayList;
    }

    private String getStoredUserAgentString(String str) {
        synchronized (this) {
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Iterator it = ((Set) entry.getValue()).iterator();
                    while (it.hasNext()) {
                        if (str.equals((String) it.next())) {
                            return entry.getKey();
                        }
                    }
                }
            }
            return null;
        }
    }

    private void removeStoredDate(String str) {
        synchronized (this) {
            String storedUserAgentString = getStoredUserAgentString(str);
            if (storedUserAgentString == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(storedUserAgentString, new HashSet()));
            hashSet.remove(str);
            if (hashSet.isEmpty()) {
                this.firebaseSharedPreferences.edit().remove(storedUserAgentString).commit();
            } else {
                this.firebaseSharedPreferences.edit().putStringSet(storedUserAgentString, hashSet).commit();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void postHeartBeatCleanUp() {
        synchronized (this) {
            String formattedDate = getFormattedDate(System.currentTimeMillis());
            this.firebaseSharedPreferences.edit().putString(LAST_STORED_DATE, formattedDate).commit();
            removeStoredDate(formattedDate);
        }
    }

    private String getFormattedDate(long j) {
        Instant ofEpochMilli;
        synchronized (this) {
            if (Build.VERSION.SDK_INT >= 26) {
                ofEpochMilli = Instant.ofEpochMilli(new Date(j).getTime());
                return ofEpochMilli.atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.MyBillsEntityDataFactory);
            }
            return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void storeHeartBeat(long j, String str) {
        synchronized (this) {
            String formattedDate = getFormattedDate(j);
            if (this.firebaseSharedPreferences.getString(LAST_STORED_DATE, "").equals(formattedDate)) {
                return;
            }
            long j2 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
            if (j2 + 1 == 30) {
                cleanUpStoredHeartBeats();
                j2 = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str, new HashSet()));
            hashSet.add(formattedDate);
            this.firebaseSharedPreferences.edit().putStringSet(str, hashSet).putLong(HEART_BEAT_COUNT_TAG, j2 + 1).putString(LAST_STORED_DATE, formattedDate).commit();
        }
    }

    private void cleanUpStoredHeartBeats() {
        synchronized (this) {
            long j = this.firebaseSharedPreferences.getLong(HEART_BEAT_COUNT_TAG, 0L);
            String str = null;
            String str2 = "";
            for (Map.Entry<String, ?> entry : this.firebaseSharedPreferences.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str3 : (Set) entry.getValue()) {
                        if (str == null || str.compareTo(str3) > 0) {
                            str2 = entry.getKey();
                            str = str3;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(this.firebaseSharedPreferences.getStringSet(str2, new HashSet()));
            hashSet.remove(str);
            this.firebaseSharedPreferences.edit().putStringSet(str2, hashSet).putLong(HEART_BEAT_COUNT_TAG, j - 1).commit();
        }
    }

    long getLastGlobalHeartBeat() {
        long j;
        synchronized (this) {
            j = this.firebaseSharedPreferences.getLong(GLOBAL, -1L);
        }
        return j;
    }

    void updateGlobalHeartBeat(long j) {
        synchronized (this) {
            this.firebaseSharedPreferences.edit().putLong(GLOBAL, j).commit();
        }
    }

    boolean isSameDateUtc(long j, long j2) {
        boolean equals;
        synchronized (this) {
            equals = getFormattedDate(j).equals(getFormattedDate(j2));
        }
        return equals;
    }

    boolean shouldSendSdkHeartBeat(String str, long j) {
        synchronized (this) {
            if (this.firebaseSharedPreferences.contains(str)) {
                if (isSameDateUtc(this.firebaseSharedPreferences.getLong(str, -1L), j)) {
                    return false;
                }
                this.firebaseSharedPreferences.edit().putLong(str, j).commit();
                return true;
            }
            this.firebaseSharedPreferences.edit().putLong(str, j).commit();
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean shouldSendGlobalHeartBeat(long j) {
        boolean shouldSendSdkHeartBeat;
        synchronized (this) {
            shouldSendSdkHeartBeat = shouldSendSdkHeartBeat(GLOBAL, j);
        }
        return shouldSendSdkHeartBeat;
    }
}
