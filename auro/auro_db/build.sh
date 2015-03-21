#!/bin/bash
# This is a simple build script, place your post-deploy but pre-start commands
# in this script. This script gets executed directly, so it could be python,
# php, ruby, etc.
set -e
if [ -z $OPENSHIFT_DB_HOST ]
then
echo 1>&2
echo "Could not find mysql database. Please run:" 1>&2
echo "rhc-ctl-app -a $OPENSHIFT_APP_NAME -e add-mysql-5.1" 1>&2
echo "then make a sample commit (add whitespace somewhere) and re-push" 1>&2
echo 1>&2
exit 5
fi
# Confirm database exists, if not create it
if ! /usr/bin/mysql -u "$OPENSHIFT_DB_USERNAME" --password="$OPENSHIFT_DB_PASSWORD" -h "$OPENSHIFT_DB_HOST" -e "select * from actions;;" "$OPENSHIFT_APP_NAME" > /dev/null
then
echo
echo "Schema not found! Importing schema from .openshift/action_hooks/telapp_auro.sql"
echo
/usr/bin/mysql -u "$OPENSHIFT_DB_USERNAME" --password="$OPENSHIFT_DB_PASSWORD" -h "$OPENSHIFT_DB_HOST" "$OPENSHIFT_APP_NAME" < "$OPENSHIFT_REPO_DIR/.openshift/action_hooks/telapp_auro.sql"
echo
echo "done."
else
echo "Database found, skipping import."
fi