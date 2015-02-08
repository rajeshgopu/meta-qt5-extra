SUMMARY = "Tools based on KDE Frameworks 5 to better interact with the system"
LICENSE = "GPLv2 & LGPLv2.1"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
    file://COPYING.LIB;md5=4fbd65380cdd255951079008b364516c \
"

inherit kde-plasma

DEPENDS += " \
    qtsvg \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "qtx11extras", "",d)} \
    \
    kconfig \
    kiconthemes \
    ki18n \
    kcmutils \
    kdesu \
    kdelibs4support \
    kwindowsystem \
"

PV = "${PLASMA_VERSION}"
SRC_URI[md5sum] = "fdd6ec4c00fe14409944dbe20572b0eb"
SRC_URI[sha256sum] = "b812932fdbb17c88326db33669a45fb8f719819e144205ac073d6037518e2353"

# do not move so-libs to -dev package
FILES_SOLIBSDEV = ""

FILES_${PN} += " \
    ${datadir}/kservices5 \
    ${libdir}/plugins \
    ${libdir}/libkdeinit5_kcmshell5.so \
"

FILES_${PN}-dbg += " \
    ${libdir}/*/.debug \
"