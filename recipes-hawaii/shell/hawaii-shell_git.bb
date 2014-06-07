DESCRIPTION = "Hawaii desktop environment shell"
LICENSE = "LGPLv2 LGPLv2.1"
LIC_FILES_CHKSUM = " \
	file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263 \
	file://COPYING.LIB;md5=4b54a1fd55a448865a0b32d41598759d \
"

inherit cmake_qt5

DEPENDS = "qtbase qtdeclarative qtwayland qtwayland-native qtscript libhawaii fluid greenisland polkit-qt-1 qtconfiguration qtaccountsservice pixman wayland weston systemd alsa-lib"
RRECOMMENDS_${PN} += "hawaii-wallpapers"

SRC_URI = " \
	git://github.com/mauios/${BPN}.git;protocol=git;branch=dev \
	file://0001-GetGitRevision.cmake-call-git-directly-it-is-not-fou.patch \
	file://0002-add-hawaii_-prefix-to-autogenrated-member-functions.patch \
"
SRCREV = "2785c40dccbef8bd7e26da997e600bb7a186944c"
PV = "0.2.90+git${SRCPV}"

S = "${WORKDIR}/git"

# make it find qtwaylandscanner / install starter scripts in bindir
EXTRA_OECMAKE += " \
	-DCMAKE_PROGRAM_PATH=${STAGING_DIR_NATIVE}/$bindir/qt5 \
	-DCMAKE_INSTALL_LIBEXECDIR=${bindir} \
	-DADDITIONAL_PATH=${bindir}/${QT_DIR_NAME} \
"

FILES_${PN} += " \
	${datadir}/hawaii \
	${libdir}/hawaii \
	${libdir}/weston \
"
FILES_${PN}-dbg += " \
	${libdir}/hawaii/plugins/*/.debug \
	${libdir}/hawaii/qml/Hawaii/Shell/*/.debug \
	${libdir}/hawaii/qml/Hawaii/Shell/*/*/.debug \
	${libdir}/weston/.debug \
"

# starter scripts rely on bash and qdbus
RDEPENDS_${PN} = "bash qttools-tools qtwayland-plugins weston"