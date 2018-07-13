# ------------------------------------------------------------------------
#
# Copyright WSO2, Inc. (http://wso2.com)
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License
#
# ------------------------------------------------------------------------

FROM java:8-jre
MAINTAINER ajanthan@wso2.com

WORKDIR /opt

# --------------------------------
# Copy scripts, packages & plugins
# --------------------------------
COPY target/Catalog-Service-0.1-SNAPSHOT.jar /opt/
COPY netty-transports.yml /opt/

# ----------------------
# Expose container ports
# ----------------------
EXPOSE 9090

ENTRYPOINT java -Dtransports.netty.conf=/opt/netty-transports.yml -jar /opt/*.jar
