#
# @APP_NAME@ dockerfile.
#

# Pull base image.
FROM @BASE_IMAGE@

# Install Java.
RUN \
  echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | debconf-set-selections && \
  add-apt-repository -y ppa:webupd8team/java && \
  apt-get update && \
  apt-get install -y oracle-java8-installer && \
  rm -rf /var/lib/apt/lists/* && \
  rm -rf /var/cache/oracle-jdk8-installer

# Define commonly used JAVA_HOME variable
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle

COPY ./@APP_NAME@-@APP_VERSION@.jar /@APP_NAME@/

# Define working directory.
WORKDIR /work-dir

ENTRYPOINT ["java", "-jar", "/@APP_NAME@/@APP_NAME@-@APP_VERSION@.jar"]

EXPOSE @PORT@
