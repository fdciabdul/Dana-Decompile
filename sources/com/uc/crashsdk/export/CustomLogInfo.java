package com.uc.crashsdk.export;

import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes8.dex */
public class CustomLogInfo {
    public boolean mAddFooter;
    public boolean mAddHeader;
    public boolean mAddLogcat;
    public boolean mAddThreadsDump;
    public ArrayList<String> mCachedInfos;
    public ArrayList<String> mCallbacks;
    public StringBuffer mData;
    public ArrayList<String> mDumpFiles;
    public ArrayList<Integer> mDumpTids;
    public String mLogType;
    public boolean mUploadNow;

    public CustomLogInfo(StringBuffer stringBuffer, String str) {
        this.mAddHeader = true;
        this.mAddFooter = true;
        this.mAddLogcat = false;
        this.mUploadNow = false;
        this.mAddThreadsDump = false;
        this.mDumpFiles = null;
        this.mCallbacks = null;
        this.mCachedInfos = null;
        this.mDumpTids = null;
        this.mData = stringBuffer;
        this.mLogType = str;
    }

    public CustomLogInfo(CustomLogInfo customLogInfo) {
        this.mAddHeader = true;
        this.mAddFooter = true;
        this.mAddLogcat = false;
        this.mUploadNow = false;
        this.mAddThreadsDump = false;
        this.mDumpFiles = null;
        this.mCallbacks = null;
        this.mCachedInfos = null;
        this.mDumpTids = null;
        this.mData = customLogInfo.mData;
        this.mLogType = customLogInfo.mLogType;
        this.mAddHeader = customLogInfo.mAddHeader;
        this.mAddFooter = customLogInfo.mAddFooter;
        this.mAddLogcat = customLogInfo.mAddLogcat;
        this.mUploadNow = customLogInfo.mUploadNow;
        this.mAddThreadsDump = customLogInfo.mAddThreadsDump;
        if (customLogInfo.mDumpFiles != null) {
            this.mDumpFiles = new ArrayList<>();
            Iterator<String> it = customLogInfo.mDumpFiles.iterator();
            while (it.hasNext()) {
                this.mDumpFiles.add(it.next());
            }
        }
        if (customLogInfo.mCallbacks != null) {
            this.mCallbacks = new ArrayList<>();
            Iterator<String> it2 = customLogInfo.mCallbacks.iterator();
            while (it2.hasNext()) {
                this.mCallbacks.add(it2.next());
            }
        }
        if (customLogInfo.mCachedInfos != null) {
            this.mCachedInfos = new ArrayList<>();
            Iterator<String> it3 = customLogInfo.mCachedInfos.iterator();
            while (it3.hasNext()) {
                this.mCachedInfos.add(it3.next());
            }
        }
        if (customLogInfo.mDumpTids != null) {
            this.mDumpTids = new ArrayList<>();
            Iterator<Integer> it4 = customLogInfo.mDumpTids.iterator();
            while (it4.hasNext()) {
                this.mDumpTids.add(it4.next());
            }
        }
    }
}
