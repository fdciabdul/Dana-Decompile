package com.alibaba.griver.base.resource.plugin.storage;

import android.text.TextUtils;
import com.alibaba.ariver.resource.api.models.PluginModel;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes6.dex */
public class GriverPluginInfoStorage {

    /* renamed from: a  reason: collision with root package name */
    private static GriverPluginStorageProxy f6371a = new GriverPluginSQLiteStorage(new GriverPluginInfoDBHelper(GriverEnv.getApplicationContext()));

    public static PluginModel queryHighestPluginInfo(String str) {
        return null;
    }

    public static void savePluginInfo(PluginModel pluginModel) {
        if (pluginModel == null || TextUtils.isEmpty(pluginModel.getVersion()) || TextUtils.isEmpty(pluginModel.getAppId())) {
            GriverLogger.w("GriverPluginInfoStorage", "plug is not valid, return directly");
            return;
        }
        PluginDao pluginDao = new PluginDao();
        pluginDao.setPluginId(pluginModel.getAppId());
        pluginDao.setVersion(pluginModel.getVersion());
        pluginDao.setPluginInfo(pluginModel);
        f6371a.insertOrUpdateInfo(pluginDao);
    }

    public static void savePluginInfos(List<PluginModel> list) {
        if (list == null || list.isEmpty()) {
            GriverLogger.w("GriverPluginInfoStorage", "save plugin infos is empty, return directly");
            return;
        }
        Iterator<PluginModel> it = list.iterator();
        while (it.hasNext()) {
            savePluginInfo(it.next());
        }
    }

    public static List<PluginModel> queryPluginInfo(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            List<PluginDao> selectAllPluginInfo = f6371a.selectAllPluginInfo(str);
            if (!selectAllPluginInfo.isEmpty()) {
                Iterator<PluginDao> it = selectAllPluginInfo.iterator();
                while (it.hasNext()) {
                    arrayList.add(it.next().getPluginInfo());
                }
            }
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("query plugin fail pluginId : ");
            sb.append(str);
            GriverLogger.e("GriverPluginInfoStorage", sb.toString());
        }
        return arrayList;
    }

    public static PluginModel queryPluginInfo(String str, String str2) {
        try {
            PluginDao selectPluginInfo = f6371a.selectPluginInfo(str, str2);
            if (selectPluginInfo != null) {
                return selectPluginInfo.getPluginInfo();
            }
            return null;
        } catch (Exception e) {
            StringBuilder sb = new StringBuilder();
            sb.append("query plugin for ");
            sb.append(str);
            sb.append(" with version: ");
            sb.append(str2);
            sb.append(" failed");
            GriverLogger.e("GriverPluginInfoStorage", sb.toString(), e);
            return null;
        }
    }

    public static void updatePluginInfo(PluginModel pluginModel) {
        if (pluginModel == null) {
            return;
        }
        try {
            PluginDao selectPluginInfo = f6371a.selectPluginInfo(pluginModel.getAppId(), pluginModel.getVersion());
            if (selectPluginInfo != null) {
                selectPluginInfo.setPluginId(pluginModel.getAppId());
                selectPluginInfo.setVersion(pluginModel.getVersion());
                selectPluginInfo.setPluginInfo(pluginModel);
                selectPluginInfo.setLastRefreshTimestamp(System.currentTimeMillis());
            }
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("update plugin for ");
            sb.append(pluginModel.getAppId());
            sb.append(" with version: ");
            sb.append(pluginModel.getVersion());
            sb.append(" failed");
            GriverLogger.e("GriverPluginInfoStorage", sb.toString());
        }
    }

    public static long queryLastRefreshTimestamp(String str, String str2) {
        PluginDao pluginDao;
        try {
            pluginDao = f6371a.selectPluginInfo(str, str2);
        } catch (Exception unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("query plugin last refresh timestamp for ");
            sb.append(str);
            sb.append(" failed");
            GriverLogger.e("GriverPluginInfoStorage", sb.toString());
            pluginDao = null;
        }
        if (pluginDao == null) {
            return 0L;
        }
        return pluginDao.getLastRefreshTimestamp();
    }

    public static List<PluginModel> queryPluginInfos() {
        List<PluginDao> list;
        ArrayList arrayList = null;
        try {
            list = f6371a.selectAllPluginInfos();
        } catch (Exception unused) {
            GriverLogger.e("GriverPluginInfoStorage", "query all plugin info failed");
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            arrayList = new ArrayList();
            Iterator<PluginDao> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getPluginInfo());
            }
        }
        return arrayList;
    }
}
