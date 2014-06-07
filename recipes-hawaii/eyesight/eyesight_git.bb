DESCRIPTION = "Image viewer for the Hawaii desktop environment"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

inherit cmake_qt5

DEPENDS = "qtbase qttools-native"

SRC_URI = "git://github.com/mauios/${BPN}.git;protocol=git;branch=dev"
SRCREV = "6438ca8bd17ebbad98e6ed146cac7ed423f739bb"
PV = "0.1.2+git${SRCPV}"

S = "${WORKDIR}/git"

EXTRA_OECMAKE += "-DQt5LinguistTools_DIR=${STAGING_LIBDIR_NATIVE}/cmake/Qt5LinguistTools"