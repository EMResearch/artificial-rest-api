
#!/usr/bin/env python3

EVOMASTER_VERSION = "0.4.1-SNAPSHOT"

import os
import shutil
import platform
from shutil import copy
from subprocess import run
from os.path import expanduser


HOME = expanduser("~")
SCRIPT_LOCATION = os.path.dirname(os.path.realpath(__file__))
PROJ_LOCATION = os.path.abspath(os.path.join(SCRIPT_LOCATION, os.pardir))

if  platform.system() == 'Windows':
    mvnres = run(["mvn", "clean", "install", "-DskipTests"], cwd=PROJ_LOCATION, shell=True)
else:
    mvnres = run(["mvn", "clean", "install", "-DskipTests"], cwd=PROJ_LOCATION)
    mvnres = mvnres.returncode

if mvnres != 0:
    print("\nERROR: Maven command failed")
    exit(1)

dist = os.path.join(PROJ_LOCATION, "dist")

if os.path.exists(dist):
    shutil.rmtree(dist)

os.mkdir(dist)

copy("n5-dense-shown/n5-dense-shown-cs/target/n5-dense-shown-sut.jar", dist)
copy("n5-dense-shown/n5-dense-shown-ex/target/n5-dense-shown-runner.jar", dist)

copy("n5-medium-shown/n5-medium-shown-cs/target/n5-medium-shown-sut.jar", dist)
copy("n5-medium-shown/n5-medium-shown-ex/target/n5-medium-shown-runner.jar", dist)

copy("n5-sparse-shown/n5-sparse-shown-cs/target/n5-sparse-shown-sut.jar", dist)
copy("n5-sparse-shown/n5-sparse-shown-ex/target/n5-sparse-shown-runner.jar", dist)

copy("n5-dense-pd-shown/n5-dense-pd-shown-cs/target/n5-dense-pd-shown-sut.jar", dist)
copy("n5-dense-pd-shown/n5-dense-pd-shown-ex/target/n5-dense-pd-shown-runner.jar", dist)

copy("n5-medium-pd-shown/n5-medium-pd-shown-cs/target/n5-medium-pd-shown-sut.jar", dist)
copy("n5-medium-pd-shown/n5-medium-pd-shown-ex/target/n5-medium-pd-shown-runner.jar", dist)

copy("n5-sparse-pd-shown/n5-sparse-pd-shown-cs/target/n5-sparse-pd-shown-sut.jar", dist)
copy("n5-sparse-pd-shown/n5-sparse-pd-shown-ex/target/n5-sparse-pd-shown-runner.jar", dist)

copy("n5-dense-hide/n5-dense-hide-cs/target/n5-dense-hide-sut.jar", dist)
copy("n5-dense-hide/n5-dense-hide-ex/target/n5-dense-hide-runner.jar", dist)

copy("n5-medium-hide/n5-medium-hide-cs/target/n5-medium-hide-sut.jar", dist)
copy("n5-medium-hide/n5-medium-hide-ex/target/n5-medium-hide-runner.jar", dist)

copy("n5-sparse-hide/n5-sparse-hide-cs/target/n5-sparse-hide-sut.jar", dist)
copy("n5-sparse-hide/n5-sparse-hide-ex/target/n5-sparse-hide-runner.jar", dist)

copy("n5-dense-pd-hide/n5-dense-pd-hide-cs/target/n5-dense-pd-hide-sut.jar", dist)
copy("n5-dense-pd-hide/n5-dense-pd-hide-ex/target/n5-dense-pd-hide-runner.jar", dist)

copy("n5-medium-pd-hide/n5-medium-pd-hide-cs/target/n5-medium-pd-hide-sut.jar", dist)
copy("n5-medium-pd-hide/n5-medium-pd-hide-ex/target/n5-medium-pd-hide-runner.jar", dist)

copy("n5-sparse-pd-hide/n5-sparse-pd-hide-cs/target/n5-sparse-pd-hide-sut.jar", dist)
copy("n5-sparse-pd-hide/n5-sparse-pd-hide-ex/target/n5-sparse-pd-hide-runner.jar", dist)


copy(HOME + "/.m2/repository/org/evomaster/evomaster-client-java-instrumentation/"
   + EVOMASTER_VERSION + "/evomaster-client-java-instrumentation-"
   + EVOMASTER_VERSION + ".jar",
   os.path.join(dist, "evomaster-agent.jar"))

zipName = "dist.zip"
if os.path.exists(zipName):
    os.remove(zipName)

print("Creating " + zipName)
shutil.make_archive(base_name=dist, format='zip', root_dir=dist+"/..", base_dir='dist')
            