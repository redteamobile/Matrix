#!/usr/bin/env bash

usage() { echo "Usage: $0 {start|stop|restart|status} [version]" 1>&2; exit 1; }

CURRDIR=`dirname "$0"`
BASEDIR=`cd "$CURRDIR"; cd ..; pwd`
PROFILE=online

# Retrieve NAME and VERSION(last modified)
jarfile=$(ls -t ${BASEDIR}/libs/*.jar | head -n1)
jarfile=$(basename ${jarfile})
NAME=${jarfile%%-*}
VERSION=${jarfile#*-}
VERSION=${VERSION%.jar}

# Override VERSION if specified
[[ -n $2 ]] && VERSION=$2

#
EXECUTEDIR=${BASEDIR}
cd "$EXECUTEDIR"

PID_FILE="$EXECUTEDIR"/logs/"$NAME".pid

#
check_pid() {
    RETVAL=1
    if [ -f $PID_FILE ]; then
        PID=`cat $PID_FILE`
#         ls /proc/$PID > /dev/null 2>&1
#          if [ $? -eq 0 ];then
#               RETVAL=0
#          fi
          R=`jps -l | grep $PID`
          if [ ${#R} -gt 1 ];then
               RETVAL=0
          fi

    fi
}
#
check_running() {
    PID=0
    RETVAL=0
    check_pid
    if [ $RETVAL -eq 0 ]; then
        echo "$NAME is running as $PID, we'll do nothing"
        exit
    fi
}

APP_HOME=$EXECUTEDIR
APP_LIB=$BASEDIR/libs
APP_LOGS=$EXECUTEDIR/logs
APP_OUT=$APP_LOGS/out.log

JAR_NAME=$APP_LIB/$NAME-$VERSION.jar

HEAP_OPTS="-Xmx2048m -Xms2048m -XX:NewSize=128m"
JMX_OPTS="-Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.port=12105 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false"
JAVA_OPTS="-verbosegc -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -XX:+PrintTenuringDistribution -XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
JAVA_CLS_OPTS="-classpath $APP_CLSPATH"
SPRING_BOOT_OPTS="-Dspring.profiles.active=$PROFILE"
#
start() {
     check_running
	 echo '======================================================'
	 echo '' `java -version`
     echo '  command:java -jar' $HEAP_OPTS $JAVA_OPTS $JMX_OPTS $SPRING_BOOT_OPTS $JAR_NAME
     echo '     time:' `date "+%Y-%m-%d %H:%M:%S"`
     echo '  apphome:' $APP_HOME
     echo 'classpath:' $APP_CLSPATH
     echo '======================================================'
     java -jar $HEAP_OPTS $JAVA_OPTS $JMX_OPTS $SPRING_BOOT_OPTS $JAR_NAME > "$APP_OUT" 2>&1 &
     PID=$!
     echo $PID > "$APP_LOGS"/"$NAME".pid
     echo "$NAME run as $PID"
     exit 0
}
#
stop() {
    check_pid
    if [ $RETVAL -eq 0 ]; then
        echo "$NAME is stopping it..."
#         java -classpath $APP_CLSPATH $JASF_OPTS cn.domob.jasf.bootstrap.Bootstrap shutdown > "$APP_OUT"
           while true
                do
                    kill -15 `cat $PID_FILE`
                      if [ $? > 0 ]; then
                          break
                      fi
#                     check_pid
#                         if [ $RETVAL -eq 0 ]; then
#                             echo "waiting $NAME shutdown..."
#                                 sleep 1
#                         else
#                         echo "done"
#                                 break
#                         fi
                done
    else
        echo "$NAME is not running, do nothing"
    fi
    if [ -f $PID_FILE ]; then
        rm $PID_FILE
    fi
}
#
status() {
    check_pid
    if [[ $RETVAL -eq 0 ]]; then
        echo "$NAME (pid $PID) is running..."
    else
        echo "$NAME is stopped"
    fi
}
#
RETVAL=0
case "$1" in
    start)
        start $@
        ;;
    stop)
        stop
        ;;
    restart)
        stop
        sleep 3
        start $@
        ;;
    status)
        status
        ;;
    *)
        echo "Version: $VERSION"
        usage
esac
exit $RETVAL
