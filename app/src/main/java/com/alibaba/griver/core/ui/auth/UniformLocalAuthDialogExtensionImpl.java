package com.alibaba.griver.core.ui.auth;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.alibaba.ariver.app.api.App;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.RVProxy;
import com.alibaba.ariver.kernel.common.service.RVAccountService;
import com.alibaba.ariver.kernel.common.storage.KVStorageProxy;
import com.alibaba.ariver.permission.service.LocalAuthPermissionManager;
import com.alibaba.ariver.permission.view.LocalPermissionDialog;
import com.alibaba.ariver.permission.view.PermissionPermitListener;
import com.alibaba.ariver.resource.api.models.AppModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.griver.api.open.GriverAboutUrlExtension;
import com.alibaba.griver.api.ui.auth.GriverLocalAuthDialogExtension;
import com.alibaba.griver.base.common.adapter.ImageListener;
import com.alibaba.griver.base.common.env.GriverEnv;
import com.alibaba.griver.base.common.logger.GriverLogger;
import com.alibaba.griver.base.common.utils.AppInfoUtils;
import com.alibaba.griver.base.common.utils.ImageUtils;
import com.alibaba.griver.base.ui.widget.GriverBottomPopupDialog;
import com.alibaba.griver.core.Griver;
import com.alibaba.griver.core.R;
import com.alibaba.griver.core.jsapi.aboutinfo.AboutInfoBridgeExtension;
import com.alibaba.griver.core.ui.activity.GriverBaseActivity;
import com.alibaba.griver.ui.popmenu.TinyAppActionState;
import com.fullstory.instrumentation.InstrumentInjector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes6.dex */
public class UniformLocalAuthDialogExtensionImpl implements GriverLocalAuthDialogExtension {

    /* renamed from: a  reason: collision with root package name */
    private static final Map<String, String> f6466a;

    static {
        HashMap hashMap = new HashMap();
        f6466a = hashMap;
        hashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CAMERA, "access your camera");
        hashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM, "access your album");
        hashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_BLUETOOTH, "access Bluetooth");
        hashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CONTACT, "access your contact");
        hashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_USERLOCATION, "access your current location");
        hashMap.put(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_RECORD, "access microphone");
    }

    @Override // com.alibaba.griver.api.ui.auth.GriverLocalAuthDialogExtension
    public LocalPermissionDialog createDialog(Context context) {
        return new UniformLocalAuthDialog(context);
    }

    /* loaded from: classes6.dex */
    static class UniformLocalAuthDialog implements LocalPermissionDialog {

        /* renamed from: a  reason: collision with root package name */
        private Context f6467a;
        private String b;
        private String c;
        private String d;
        private PermissionPermitListener e;
        private List<String> f = new ArrayList();

        public UniformLocalAuthDialog(Context context) {
            this.f6467a = context;
        }

        @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
        public void setDialogContent(String str, String str2, String str3) {
            this.b = str;
            this.c = str2;
            this.d = str3;
        }

        @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
        public void setDialogExtraData(Map<String, String> map) {
            List parseArray;
            String str = map.get("scopes");
            if (TextUtils.isEmpty(str) || (parseArray = JSON.parseArray(str, String.class)) == null) {
                return;
            }
            this.f.addAll(parseArray);
        }

        @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
        public void setPermissionPermitListener(PermissionPermitListener permissionPermitListener) {
            this.e = permissionPermitListener;
        }

        @Override // com.alibaba.ariver.permission.view.LocalPermissionDialog
        public void show() {
            Activity activity;
            App currentApp;
            WeakReference<Activity> topActivity = GriverEnv.getTopActivity();
            Page activePage = (topActivity == null || (activity = topActivity.get()) == null || !(activity instanceof GriverBaseActivity) || (currentApp = ((GriverBaseActivity) activity).getCurrentApp()) == null) ? null : currentApp.getActivePage();
            if (activePage == null) {
                return;
            }
            if (this.f.size() > 1 && !this.f.contains(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CHOOSE_PHOTOS_ALBUM) && !this.f.contains(LocalAuthPermissionManager.SCOPE.CONST_SCOPE_CAMERA)) {
                GriverLogger.w("UniformLocalAuthDialogExtensionImpl", "more than one scope are requested, but not album and camera, ignore request");
                this.e.onSuccess();
                return;
            }
            View inflate = LayoutInflater.from(this.f6467a).inflate(R.layout.griver_core_local_auth_content, (ViewGroup) null);
            final GriverBottomPopupDialog griverBottomPopupDialog = new GriverBottomPopupDialog(this.f6467a, inflate);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_name);
            textView.setOnClickListener(new ClickNameListener(activePage));
            final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_icon);
            imageView.setOnClickListener(new ClickNameListener(activePage));
            inflate.findViewById(R.id.iv_more).setOnClickListener(new ClickNameListener(activePage));
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_content);
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.layout_not_retry);
            List<String> list = this.f;
            if (list != null && list.size() > 0) {
                Iterator<String> it = this.f.iterator();
                while (it.hasNext()) {
                    if ("0".equals(b(activePage.getApp().getAppId(), it.next()))) {
                        relativeLayout.setVisibility(0);
                    }
                }
            }
            final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.check_box);
            textView.setText(this.c);
            List<String> list2 = this.f;
            if (list2 != null) {
                if (list2.size() <= 1) {
                    this.b = (String) UniformLocalAuthDialogExtensionImpl.f6466a.get(this.f.get(0));
                } else {
                    this.b = "access your album and camera";
                }
            }
            textView2.setText(this.b);
            ImageUtils.loadImage(this.d, new ImageListener() { // from class: com.alibaba.griver.core.ui.auth.UniformLocalAuthDialogExtensionImpl.UniformLocalAuthDialog.1
                @Override // com.alibaba.griver.base.common.adapter.ImageListener
                public void onImage(Bitmap bitmap) {
                    imageView.setImageBitmap(bitmap);
                }
            });
            a((ImageView) inflate.findViewById(R.id.iv_scope), this.f);
            ((Button) inflate.findViewById(R.id.bt_refuse)).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.auth.UniformLocalAuthDialogExtensionImpl.UniformLocalAuthDialog.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    griverBottomPopupDialog.dismiss();
                    if (checkBox.isChecked()) {
                        UniformLocalAuthDialog.this.e.onFailed(-1, "refused", false);
                    } else {
                        UniformLocalAuthDialog.this.e.onFailed(-1, "refused", true);
                    }
                }
            });
            ((Button) inflate.findViewById(R.id.bt_allow)).setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.griver.core.ui.auth.UniformLocalAuthDialogExtensionImpl.UniformLocalAuthDialog.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    UniformLocalAuthDialog.this.e.onSuccess();
                    griverBottomPopupDialog.dismiss();
                }
            });
            griverBottomPopupDialog.setCancelable(false);
            griverBottomPopupDialog.show();
        }

        private void a(ImageView imageView, List<String> list) {
            if (list != null && list.size() == 1) {
                String str = list.get(0);
                if (str == null) {
                    return;
                }
                if (str.contains("camera")) {
                    InstrumentInjector.Resources_setImageResource(imageView, R.drawable.griver_core_scope_camera);
                    return;
                } else if (!str.contains("album")) {
                    if (str.contains("audioRecord")) {
                        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.griver_core_scope_microphone);
                        return;
                    } else if (str.contains("location")) {
                        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.griver_core_scope_location);
                        return;
                    } else if (str.contains("contact")) {
                        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.griver_core_scope_contact);
                        return;
                    } else if (str.contains(TinyAppActionState.ACTION_BLUE_TOOTH)) {
                        InstrumentInjector.Resources_setImageResource(imageView, R.drawable.griver_core_scope_bluetooth);
                        return;
                    } else {
                        return;
                    }
                }
            }
            InstrumentInjector.Resources_setImageResource(imageView, R.drawable.griver_core_scope_album);
        }

        private String a(String str, String str2) {
            String userId = ((RVAccountService) RVProxy.get(RVAccountService.class)).getUserId();
            StringBuilder sb = new StringBuilder();
            sb.append(userId);
            sb.append("_");
            sb.append(str);
            sb.append("_");
            sb.append(str2.substring(str2.indexOf(".") + 1, str2.length()));
            return sb.toString();
        }

        private String b(String str, String str2) {
            return ((KVStorageProxy) RVProxy.get(KVStorageProxy.class)).getString(str, a(str, str2));
        }

        /* loaded from: classes6.dex */
        static class ClickNameListener implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            private Page f6468a;

            public ClickNameListener(Page page) {
                this.f6468a = page;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a(this.f6468a);
            }

            private void a(Page page) {
                if (page == null) {
                    return;
                }
                String aboutUrl = ((GriverAboutUrlExtension) RVProxy.get(GriverAboutUrlExtension.class)).getAboutUrl(page);
                if (TextUtils.isEmpty(aboutUrl)) {
                    GriverLogger.w("UniformLocalAuthDialogExtensionImpl", "no about url integrated, do not open");
                    return;
                }
                Bundle bundle = new Bundle();
                bundle.putString(AboutInfoBridgeExtension.PARAM_QUERY_APP_ID, page.getApp().getAppId());
                bundle.putString(AboutInfoBridgeExtension.PARAM_QUERY_APP_VERSION, AppInfoUtils.getDeveloperVersion((AppModel) page.getApp().getData(AppModel.class)));
                Griver.openUrl(GriverEnv.getApplicationContext(), aboutUrl, bundle);
            }
        }
    }
}
