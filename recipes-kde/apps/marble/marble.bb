SUMMARY = "Marble is a Virtual Globe and World Atlas"
LICENSE = "GPLv3 & GFDL-1.2 & LGPLv2 & MIT"
LIC_FILES_CHKSUM = " \
    file://LICENSE.GPL-3;md5=f27defe1e96c2e1ecd4e0c9be8967949 \
    file://LICENSE.txt;md5=e9b5891877660f283be4bc396de0570f \
    file://COPYING-CMAKE-SCRIPTS;md5=54c7042be62e169199200bc6477f04d1 \
    file://COPYING.DOC;md5=ad1419ecc56e060eccf8184a87c4285f \
"

inherit kde-apps

DEPENDS += " \
    qtsvg \
    qtwebkit \
    \
    kconfig \
    krunner \
    kservice \
    ki18n \
    kio \
    knewstuff \
    kwallet \
    kparts \
    kcoreaddons \
    kparts \
    plasma-framework \
    kdoctools \
"

PV = "${KDE_APP_VERSION}"
SRC_URI[md5sum] = "85c1b7b07c9fc8952a1a221f4d45c88e"
SRC_URI[sha256sum] = "a3c4630fbf598caf54ee7c04500e9476462bc5c53105ffcb170d71c8f7361b02"
SRC_URI += "file://0001-align-path-of-designer-plugins.patch"

PACKAGES =+ " \
    ${PN}-mobile ${PN}-qt ${PN}-touch \
    ${PN}-designer-plugin-dbg ${PN}-designer-plugin \
"

FILES_${PN}-mobile = "${bindir}/${BPN}-mobile"
FILES_${PN}-qt = "${bindir}/${BPN}-qt"
FILES_${PN}-touch = "${bindir}/${BPN}-touch"

FILES_${PN} += " \
    ${datadir}/config.kcfg \
    ${datadir}/icons \
    ${datadir}/k*5 \
    ${datadir}/appdata \
    ${OE_QMAKE_PATH_PLUGINS} \
"

FILES_${PN}-dbg += " \
    ${libdir}/marble/plugins/.debug \
    ${libdir}/marble/plugins/org/kde/edu/marble/.debug \
    ${OE_QMAKE_PATH_PLUGINS}/.debug \
"

FILES_${PN}-designer-plugin += " \
    ${OE_QMAKE_PATH_PLUGINS}/designer \
"

FILES_${PN}-designer-plugin-dbg += " \
    ${OE_QMAKE_PATH_PLUGINS}/designer/.debug \
"