#!/bin/sh
MONITORDIR="/home/pollo/files/"
inotifywait -m -e create --format '%w%f' "${MONITORDIR}" | while read NEWFILE
do
    echo "File added: ${NEWFILE}"

    curl http://localhost:8080/Hicx/sh-call?path=${NEWFILE}
done