package ru.noties.markwon;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.fullstory.instrumentation.InstrumentInjector;
import ru.noties.markwon.spans.LinkSpan;

/* loaded from: classes6.dex */
public class LinkResolverDef implements LinkSpan.Resolver {
    @Override // ru.noties.markwon.spans.LinkSpan.Resolver
    public final void BuiltInFictitiousFunctionClassFactory(View view, String str) {
        Uri parse = Uri.parse(str);
        Context context = view.getContext();
        Intent intent = new Intent("android.intent.action.VIEW", parse);
        intent.putExtra("com.android.browser.application_id", context.getPackageName());
        try {
            context.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder();
            sb.append("Actvity was not found for intent, ");
            sb.append(intent.toString());
            InstrumentInjector.log_w("LinkResolverDef", sb.toString());
        }
    }
}
