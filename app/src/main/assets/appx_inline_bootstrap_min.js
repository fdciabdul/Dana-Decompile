!function(){"use strict";window.bootstrapApp({worker:"index.worker.js",onReady:function(i){0<=navigator.userAgent.indexOf("Alipay")&&!window.AlipayJSBridge?document.addEventListener("AlipayJSBridgeReady",function(){i({bridge:window.AlipayJSBridge})}):i({bridge:window.AlipayJSBridge})}})}();