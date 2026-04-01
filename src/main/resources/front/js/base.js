(function (doc, win) {
    var docEl = doc.documentElement,
        resizeEvt = 'orientationchange' in window ? 'orientationchange' : 'resize',
        recalc = function () {
            var clientWidth = docEl.clientWidth;
            if (!clientWidth) return;
            // 桌面浏览器适配
            if (clientWidth > 1200) {
                docEl.style.fontSize = '16px';
            } else if (clientWidth > 750) {
                docEl.style.fontSize = '28px';
            } else {
                docEl.style.fontSize = (clientWidth / 375) + 'px';
            }
        };

    if (!doc.addEventListener) return;
    win.addEventListener(resizeEvt, recalc, false);
    doc.addEventListener('DOMContentLoaded', recalc, false);
})(document, window);