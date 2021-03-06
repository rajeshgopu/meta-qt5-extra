SUMMARY = "All layer packages - just for build test"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

RDEPENDS_${PN} = " \
    antimony \
    gottet \
    hawaii-world \
    hexalate \
    kde-world \
    lxqt-world \
    qmmp \
    qpdfview \
    qtiohelper \
    ${@bb.utils.contains("DISTRO_FEATURES", "x11", "sddm", "",d)} \
"
